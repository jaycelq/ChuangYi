package tjuci.dl.myweixin;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.Html;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CyToday extends Activity implements OnClickListener {
	private SensorManager sensorManager;
	private Vibrator vibrator;
	private TextView cyChance;
	private static final int SENSOR_SHAKE = 10;
	private ImageView backTri;
	private int chanceLeft = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chuangyi_today);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        cyChance = (TextView)findViewById(R.id.chuangyi_chance);
        backTri = (ImageView)findViewById(R.id.cy_today_back);
        backTri.setOnClickListener(this);
        String text = "还剩" + "<font color=#ff0000>&nbsp;"+ chanceLeft +"&nbsp;</font>次摇一摇换回忆机会";
        cyChance.setText(Html.fromHtml(text));
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	if (sensorManager != null && chanceLeft > 0) {// 注册监听器
    	sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    	// 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
    	}
    }
    
    @Override
    protected void onPause() {
    super.onPause();
    	if (sensorManager != null) {// 取消监听器
    		sensorManager.unregisterListener(sensorEventListener);
    	}
    }
    
    private SensorEventListener sensorEventListener = new SensorEventListener() {
    	@Override
    	public void onSensorChanged(SensorEvent event) {
    		// 传感器信息改变时执行该方法
    		float[] values = event.values;
    		float x = values[0]; // x轴方向的重力加速度，向右为正
    		float y = values[1]; // y轴方向的重力加速度，向前为正
    		float z = values[2]; // z轴方向的重力加速度，向上为正
    		// 一般在这三个方向的重力加速度达到40就达到了摇晃手机的状态。
    	int medumValue = 19;// 三星 i9250怎么晃都不会超过20，没办法，只设置19了
    	if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
    			vibrator.vibrate(200);
    			Message msg = new Message();
    			msg.what = SENSOR_SHAKE;
    			handler.sendMessage(msg);
    		}
    	}
    	@Override
    	public void onAccuracyChanged(Sensor sensor, int accuracy) {
    	}
    };
    
    Handler handler = new Handler() {
    	@Override
    	public void handleMessage(Message msg) {
    	super.handleMessage(msg);
    	switch (msg.what) {
    		case SENSOR_SHAKE:
    			chanceLeft -= 1;
    	        sensorManager.unregisterListener(sensorEventListener);
    	        String text = "还剩" + "<font color=#ff0000>&nbsp;"+ chanceLeft +"&nbsp;</font>次摇一摇换回忆机会";
    	        cyChance.setText(Html.fromHtml(text));
    			Intent intent = new Intent(CyToday.this, LoginActivity.class);
    			startActivity(intent);
    	        break;
    		}
    	}
    };
    
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {
		case R.id.cy_today_back:
			Intent intent = new Intent(CyToday.this, LoginIndex.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			overridePendingTransition(R.anim.left_in, R.anim.right_out);
			break;

		case R.id.main_regist_btn://注册按钮
			
			break;
		}
	}
}
