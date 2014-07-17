package tjuci.dl.myweixin;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class LileiChuangyi extends Activity implements OnClickListener {
	private TextView lileiChuangyi2;
	private ImageView btnBack;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lilei_chuangyi);
        lileiChuangyi2 = (TextView) findViewById(R.id.lilei_chuangyi_2);
        String text = "2014.6.14 " + "<font color=#B94C59>创造了新回忆</font>";
        lileiChuangyi2.setText(Html.fromHtml(text));
        btnBack = (ImageView) findViewById(R.id.cy_lilei_back);
        btnBack.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int btnId = v.getId();
		switch (btnId) {
		case R.id.cy_lilei_back:
			this.finish();
			overridePendingTransition(R.anim.left_in, R.anim.right_out);
			break;
		default:
			break;
		}
	}
}
