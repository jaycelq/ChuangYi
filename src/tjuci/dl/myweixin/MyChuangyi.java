/**
 * 
 */
package tjuci.dl.myweixin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * @author qiang
 *
 */
public class MyChuangyi extends Activity implements OnClickListener{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_chuangyi);
    }
	
	
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {//判断点击的按钮
		case R.id.main_login_btn://登录按钮

			//else {
				//Intent intent = new Intent(MyWeiXinActivity.this, LoginIndex.class);
				//startActivity(intent);//启动对应的Activity  此处为硬编码  不介意这么写  写成action形式 最好
				//this.finish();
				//Log.i("-------------", "------------------");
			//}
			break;

		case R.id.main_regist_btn://注册按钮
			
			break;
		}
	}

}
