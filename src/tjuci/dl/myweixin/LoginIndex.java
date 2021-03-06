/**
 * 
 */
package tjuci.dl.myweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author qiang
 *
 */
public class LoginIndex extends Activity implements OnClickListener{
    ImageView today;
    ImageView myChuangyiTri;
    TextView myChuangyiText;
    TextView bigMe;
    ImageView otherChuangyiTri;
    TextView otherChuangyiText;
    TextView bigOther;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_index);
        today = (ImageView) findViewById(R.id.chuangyi_today);
        today.setOnClickListener(this);
        myChuangyiTri = (ImageView) findViewById(R.id.tri2);
        myChuangyiTri.setOnClickListener(this);
        myChuangyiText = (TextView) findViewById(R.id.my_chuangyi);
        myChuangyiText.setOnClickListener(this);
        bigMe = (TextView) findViewById(R.id.big_me);
        bigMe.setOnClickListener(this);
        otherChuangyiTri = (ImageView) findViewById(R.id.tri1);
        otherChuangyiTri.setOnClickListener(this);
        otherChuangyiText = (TextView) findViewById(R.id.other_chuangyi);
        otherChuangyiText.setOnClickListener(this);
        bigOther = (TextView) findViewById(R.id.big_other);
        bigOther.setOnClickListener(this);
        
    }
    
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {
		case R.id.chuangyi_today:
			Intent intent1 = new Intent(LoginIndex.this, CyToday.class);
			intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent1);
			break;
		case R.id.big_me:
		case R.id.tri2:
		case R.id.my_chuangyi:
			Intent intent2 = new Intent(LoginIndex.this, MyChuangyi.class);
			startActivity(intent2);
			break;
		case R.id.big_other:
		case R.id.tri1:
		case R.id.other_chuangyi:
			Intent intent3 = new Intent(LoginIndex.this, OthersChuangyi.class);
			startActivity(intent3);
			break;
		case R.id.main_regist_btn://ע�ᰴť
			
			break;
		}
	}

}
