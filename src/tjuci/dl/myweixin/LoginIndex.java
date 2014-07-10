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


/**
 * @author qiang
 *
 */
public class LoginIndex extends Activity implements OnClickListener{
    ImageView today;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_index);
        today = (ImageView) findViewById(R.id.chuangyi_today);
        today.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {
		case R.id.chuangyi_today:
			Intent intent = new Intent(LoginIndex.this, CyToday.class);
			startActivity(intent);
			break;

		case R.id.main_regist_btn://ע�ᰴť
			
			break;
		}
	}

}
