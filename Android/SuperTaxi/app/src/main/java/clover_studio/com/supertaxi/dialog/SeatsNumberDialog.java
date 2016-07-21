package clover_studio.com.supertaxi.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import clover_studio.com.supertaxi.R;
import clover_studio.com.supertaxi.adapters.ShowMoreAdapter;
import clover_studio.com.supertaxi.api.retrofit.CustomResponse;
import clover_studio.com.supertaxi.api.retrofit.DriverRetroApiInterface;
import clover_studio.com.supertaxi.base.BaseActivity;
import clover_studio.com.supertaxi.models.DriverListResponse;
import clover_studio.com.supertaxi.models.post_models.PostLatLngModel;
import clover_studio.com.supertaxi.singletons.UserSingleton;
import clover_studio.com.supertaxi.utils.AnimationUtils;
import retrofit2.Call;
import retrofit2.Response;

public class SeatsNumberDialog extends Dialog {

    private OnItemClickedListener listener;
    private RelativeLayout parentLayout;

    public static SeatsNumberDialog startDialog(Context context, OnItemClickedListener lis){
        return new SeatsNumberDialog(context, lis);
    }

    public SeatsNumberDialog(Context context, final OnItemClickedListener lis) {
        super(context, R.style.Theme_Dialog_no_dim);

        setOwnerActivity((Activity) context);
        setCancelable(true);
        setCanceledOnTouchOutside(true);

        this.listener = lis;

        show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_seats_number);

        parentLayout = (RelativeLayout) findViewById(R.id.parentLayout);
        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        findViewById(R.id.rlOneSeats).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClicked(SeatsNumberDialog.this, 1);
                }
            }
        });

        findViewById(R.id.rlTwoSeats).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClicked(SeatsNumberDialog.this, 2);
                }
            }
        });

        findViewById(R.id.rlThreeSeats).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClicked(SeatsNumberDialog.this, 4);
                }
            }
        });

    }

    @Override
    public void dismiss() {
        AnimationUtils.fade(parentLayout, 1, 0, 300, new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                SeatsNumberDialog.super.dismiss();
            }
        });

    }

    @Override
    public void show() {
        super.show();
        AnimationUtils.fade(parentLayout, 0, 1, 300, null);
    }

    public interface OnItemClickedListener{
        void onClicked(SeatsNumberDialog dialog, int numberOfSeats);
    }

    public void setListener (OnItemClickedListener lis){
        listener = lis;
    }

}