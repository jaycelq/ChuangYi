package tjuci.dl.myweixin;

import android.annotation.SuppressLint;
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
        String text = "��ʣ" + "<font color=#ff0000>&nbsp;"+ chanceLeft +"&nbsp;</font>��ҡһҡ���������";
        cyChance.setText(Html.fromHtml(text));
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	if (sensorManager != null && chanceLeft > 0) {// ע�������
    	sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    	// ��һ��������Listener���ڶ������������ô��������ͣ�����������ֵ��ȡ��������Ϣ��Ƶ��
    	}
    }
    
    @Override
    protected void onPause() {
    super.onPause();
    	if (sensorManager != null) {// ȡ��������
    		sensorManager.unregisterListener(sensorEventListener);
    	}
    }
    
    private SensorEventListener sensorEventListener = new SensorEventListener() {
    	@Override
    	public void onSensorChanged(SensorEvent event) {
    		// ��������Ϣ�ı�ʱִ�и÷���
    		float[] values = event.values;
    		float x = values[0]; // x�᷽����������ٶȣ�����Ϊ��
    		float y = values[1]; // y�᷽����������ٶȣ���ǰΪ��
    		float z = values[2]; // z�᷽����������ٶȣ�����Ϊ��
    		// һ����������������������ٶȴﵽ40�ʹﵽ��ҡ���ֻ���״̬��
    	int medumValue = 19;// ���� i9250��ô�ζ����ᳬ��20��û�취��ֻ����19��
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
    	        String text = "��ʣ" + "<font color=#ff0000>&nbsp;"+ chanceLeft +"&nbsp;</font>��ҡһҡ���������";
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
//			Intent intent = new Intent(CyToday.this, LoginIndex.class);
//			intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//			startActivity(intent);
			this.finish();
			overridePendingTransition(R.anim.left_in, R.anim.right_out);
			break;

		case R.id.main_regist_btn://ע�ᰴť
			
			break;
		}
	}
}
