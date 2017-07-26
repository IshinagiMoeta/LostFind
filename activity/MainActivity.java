package com.whitesharkapps.lostfind.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.whitesharkapps.lostfind.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnDateSetListener {

    private Date lostTime = new Date();
    private Calendar calendar = Calendar.getInstance();
    private long startTime = 946702800000L;
    private TimePickerDialog mDialogAll;

    @BindView(R.id.timetext)
    TextView timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        calendar.set(2000,1,1,0,0,0);

        mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("cancel")
                .setSureStringId("sure")
                .setTitleStringId("TimePicker")
                .setCyclic(false)
                .setMinMillseconds(new Date(0,0,0).getTime())
                .setMaxMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();
    }

    @OnClick(R.id.button)
    public void checkTime(View view){
        mDialogAll.show(getSupportFragmentManager(),"All");
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        Date date = new Date(millseconds);

        Log.e("=====", String.valueOf(date.getTime()));
        Log.e("=====", String.valueOf(date.getTime() - startTime));
    }

    public boolean isBefore(Date date){
        if (date.getTime() - startTime>=0){
            return false;
        }else{
            return true;
        }
    }

}
