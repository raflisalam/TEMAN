package com.raflisalam.appteman.fitur1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.raflisalam.appteman.R;
import com.raflisalam.appteman.tensorflowlite.Classifier;
import com.raflisalam.appteman.tensorflowlite.TensorFlowImageClassifier;
import com.raflisalam.appteman.ui.HomeActivity;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class Fitur1Activity extends AppCompatActivity {

    private static final String MODEL_PATH = "model.tflite";
    private static final String LABEL_PATH = "labels.txt";
    private static final int INPUT_SIZE = 224;

    private Classifier classifier;
    private CompositeDisposable compositeDisposable;

    private CameraView cameraView;
    private Button btnCapture;
    private ImageView imgPreview;
    private TextView tv4, namaPenyakit, presentaseResults, tvGejala, deskripsiPenyakit, caraPencegahan, tvPencegahan, gejalaPenyakit;
    private String strr, strr2;
    private CardView cardView;
    String REGEX = "-|\\[|\\]|\\^|\\/|,|'|\\*|\\:|\\.|!|>|<|\\~|@|#|\\$||\\+|=\\?|\\||\\\\|\\\\\\\\|\\)|\\(";

    ImageButton btnBack, btnReCapture;

    private ArrayList<Model> dataModel;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur1);
        compositeDisposable = new CompositeDisposable();


        tvGejala = findViewById(R.id.tvGejala);
        gejalaPenyakit = findViewById(R.id.gejalaPenyakit);
        deskripsiPenyakit = findViewById(R.id.deskripsiPenyakit);
        tvPencegahan = findViewById(R.id.tvPencegahan);
        caraPencegahan = findViewById(R.id.caraPencegahan);

        cameraView = findViewById(R.id.camera);
        btnCapture = findViewById(R.id.btn_capture);
        imgPreview = findViewById(R.id.preview);
        namaPenyakit = findViewById(R.id.namaPenyakit);
        presentaseResults = findViewById(R.id.presentaseResults);
        btnReCapture = findViewById(R.id.btn_recapture);
        tv4 = findViewById(R.id.tv4);

        cardView = findViewById(R.id.cardView);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fitur1Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {
                Log.d("CameraKitListener", "image captured!");
                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
                final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
                showPreview(true, bitmap, generateResults(results));
            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.captureImage();
            }
        });

        btnReCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreview(false,null,null);
            }
        });

        initTensorFlow().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onComplete() {
                Log.i("initTensorFlow", "complete");
                showPreview(false,null,null);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("initTensorFlow", e.getMessage());
            }
        });

    }

    private void dbPenyakit() {
        dataModel = new ArrayList<>();
        db = FirebaseDatabase.getInstance().getReference("DataPenyakit");
        Log.d("sembarangmo", "model" + db);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Model model = dataSnapshot.getValue(Model.class);
                    if (model.getNamaPenyakit().equals(strr)) {
                        dataModel.add(model);
                        deskripsiPenyakit.setText(model.getDeskripsi());
                        caraPencegahan.setText(model.getCaraPencegahan());
                        gejalaPenyakit.setText(model.getGejalaPenyakit());
                        Toast.makeText(Fitur1Activity.this, "Teridentifikasi " +model.getNamaPenyakit(), Toast.LENGTH_SHORT).show();
                    } else if (model.getNamaPenyakit().equals("Padi Sehat")) {
                        dataModel.add(model);
                        deskripsiPenyakit.setText();
                        tvGejala.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        closeClassifier().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onComplete() {
                Log.i("closeClassifier","completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("closeClassifier", e.getMessage());
            }
        });
        super.onDestroy();
        compositeDisposable.clear();
    }
    private Completable closeClassifier(){
        return Completable.fromAction(() -> classifier.close()).subscribeOn(Schedulers.newThread());
    }

    private Completable initTensorFlow(){
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws IOException {
                classifier = TensorFlowImageClassifier.create(
                        getAssets(),
                        MODEL_PATH,
                        LABEL_PATH,
                        INPUT_SIZE);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    private String generateResults(List<Classifier.Recognition> data){
        String result = "";
        result = result +"\n" + data.get(0);


        return result;
    }

    private void showPreview(boolean show, @Nullable Bitmap img, @Nullable String results){

        if (show) {
            cameraView.setVisibility(View.GONE);
            btnCapture.setVisibility(View.GONE);
            btnReCapture.setVisibility(View.VISIBLE);
            imgPreview.setVisibility(View.VISIBLE);
            imgPreview.setImageBitmap(img);
            tv4.setVisibility(View.VISIBLE);
            cardView.setVisibility(View.VISIBLE);
            namaPenyakit.setVisibility(View.VISIBLE);
            presentaseResults.setVisibility(View.VISIBLE);
            String str = results.replaceAll("\\d","");
            strr = str.replace("(,%)", "").trim();
            namaPenyakit.setText(strr);
//            String str3 = results.replaceAll(REGEX,"");
//            String string = str3.replaceAll("^[\\s\\.\\d]+","");
//            String str4 = string.replaceAll("[^\\d.]","").replace("+1","");
//            presentaseResults.setText(str4);
            caraPencegahan.setVisibility(View.VISIBLE);
            tvPencegahan.setVisibility(View.VISIBLE);
            deskripsiPenyakit.setVisibility(View.VISIBLE);
            tvGejala.setVisibility(View.VISIBLE);
            gejalaPenyakit.setVisibility(View.VISIBLE);
            dbPenyakit();
        } else {
            cameraView.setVisibility(View.VISIBLE);
            btnCapture.setVisibility(View.VISIBLE);
            btnReCapture.setVisibility(View.GONE);
            imgPreview.setVisibility(View.GONE);
            namaPenyakit.setVisibility(View.GONE);
            presentaseResults.setVisibility(View.GONE);
            tv4.setVisibility(View.GONE);
            cardView.setVisibility(View.GONE);
            caraPencegahan.setVisibility(View.GONE);
            tvPencegahan.setVisibility(View.GONE);
            deskripsiPenyakit.setVisibility(View.GONE);
            tvGejala.setVisibility(View.GONE);
            gejalaPenyakit.setVisibility(View.GONE);
        }
    }
}