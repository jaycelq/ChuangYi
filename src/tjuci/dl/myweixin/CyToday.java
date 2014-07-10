package tjuci.dl.myweixin;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class CyToday extends Activity implements OnClickListener {
	TextView cyChance;
	int chanceLeft = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chuangyi_today);
        cyChance = (TextView)findViewById(R.id.chuangyi_chance);
        String text = "还剩" + "<font color=#ff0000>&nbsp;"+ chanceLeft +"&nbsp;</font>次摇一摇换回忆机会";
        cyChance.setText(Html.fromHtml(text));
    }
    
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {
		case R.id.chuangyi_today:
//			Intent intent = new Intent(CyToday.this, LoginActivity.class);
//			startActivity(intent);
			break;

		case R.id.main_regist_btn://注册按钮
			
			break;
		}
	}
}
