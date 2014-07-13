/**
 * 
 */
package tjuci.dl.myweixin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author qiang
 *
 */
public class MyChuangyi extends Activity implements OnClickListener{
	TextView myPraiseNum, myCommentNum, myTocreateNum, myChuangyi1, myChuangyi2, myChuangyiRecord1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_chuangyi);
        myPraiseNum = (TextView) findViewById(R.id.my_prasie_num);
        Spannable spanPraise = new SpannableString(myPraiseNum.getText());
        spanPraise.setSpan(new RelativeSizeSpan(1.8f), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanPraise.setSpan(new ForegroundColorSpan(Color.rgb(192, 0, 0)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        myPraiseNum.setText(spanPraise);
        myCommentNum = (TextView) findViewById(R.id.my_comment_num);
        Spannable spanComment = new SpannableString(myCommentNum.getText());
        spanComment.setSpan(new RelativeSizeSpan(1.8f), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanComment.setSpan(new ForegroundColorSpan(Color.rgb(192, 0, 0)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        myCommentNum.setText(spanComment);
        myTocreateNum = (TextView) findViewById(R.id.my_tocreate_num);
        Spannable spanCreate = new SpannableString(myTocreateNum.getText());
        spanCreate.setSpan(new RelativeSizeSpan(1.8f), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanCreate.setSpan(new ForegroundColorSpan(Color.rgb(192, 0, 0)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        myTocreateNum.setText(spanCreate);
        myChuangyi1 = (TextView) findViewById(R.id.my_chuangyi_1);
        String text = "2014.6.14 ��ע��" + "<font color=#B94C59>&nbsp;����</font>";
        myChuangyi1.setText(Html.fromHtml(text));
        myChuangyi2 = (TextView) findViewById(R.id.my_chuangyi_2);
        text = "2014.6.14 " + "<font color=#B94C59>�������»���</font>";
        myChuangyi2.setText(Html.fromHtml(text));
        myChuangyiRecord1 = (TextView) findViewById(R.id.my_chuangyi_record1);
        text = "<font color=#B94C59>��÷÷��</font>"+"����ͻ��϶����ҵ��᰸�����ܲ�΢Ц��С����ǹ������";
        myChuangyiRecord1.setText(Html.fromHtml(text));
    }
	
	
	@Override
	public void onClick(View v) {
		int btnId = v.getId();
		switch (btnId) {//�жϵ���İ�ť
		case R.id.main_login_btn://��¼��ť

			//else {
				//Intent intent = new Intent(MyWeiXinActivity.this, LoginIndex.class);
				//startActivity(intent);//������Ӧ��Activity  �˴�ΪӲ����  ��������ôд  д��action��ʽ ���
				//this.finish();
				//Log.i("-------------", "------------------");
			//}
			break;

		case R.id.main_regist_btn://ע�ᰴť
			
			break;
		}
	}

}
