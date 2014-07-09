package tjuci.dl.myweixin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * ����  �ǶԲ���main.xml�� �ؼ��Ĳ���
 * @author dl
 *
 */
public class MyWeiXinActivity extends Activity implements OnClickListener{
	Button loginBtn,registBtn;
	EditText userEdit,passwdEdit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        loginBtn = (Button)findViewById(R.id.main_login_btn);
        registBtn = (Button)findViewById(R.id.main_regist_btn);
        passwdEdit = (EditText)findViewById(R.id.login_password);
        userEdit = (EditText)findViewById(R.id.login_username);
        loginBtn.setOnClickListener(this);
        registBtn.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {//�жϵ���İ�ť
		case R.id.main_login_btn://��¼��ť
			String userEditStr = userEdit.getText().toString().trim();
			String passwdEditStr = passwdEdit.getText().toString().trim();
			if(("".equals(userEditStr) || null == userEditStr) || 
					("".equals(passwdEditStr) || null == passwdEditStr)){//ֻҪ�û�����������һ��Ϊ��
					Toast.makeText(MyWeiXinActivity.this,"�ֻ���������벻��Ϊ��", Toast.LENGTH_LONG).show();
			}
			else {
				Intent intent = new Intent(MyWeiXinActivity.this, LoginIndex.class);
				startActivity(intent);//������Ӧ��Activity  �˴�ΪӲ����  ��������ôд  д��action��ʽ ���
				Log.i("-------------", "------------------");
			}
			break;

		case R.id.main_regist_btn://ע�ᰴť
			
			break;
		}
	}
}