package com.example.mytest;
import android.R.integer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class SampleListFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		
		adapter.add(new SampleItem("丁先生", R.drawable.mm_title_btn_contact_normal,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("一键发布", R.drawable.flipper_head_publish,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("历史发布", R.drawable.icetweton,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("积分&等级", R.drawable.icotjsjn,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("成交攻略", R.drawable.targetrange_icon,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("激活码", R.drawable.logmeinignition,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("呼叫客服", R.drawable.phicon,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("给我们评分", R.drawable.todo,R.drawable.mm_submenu_normal));
		adapter.add(new SampleItem("关于", R.drawable.icc45on,R.drawable.mm_submenu_normal));
		setListAdapter(adapter);

	}

	private class SampleItem {
		public String tag;
		public int iconRes;
		public int imgRes;
		public SampleItem(String tag, int iconRes,int imgRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
			this.imgRes=imgRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			ImageView img = (ImageView) convertView.findViewById(R.id.img_icon);
			img.setImageResource(getItem(position).imgRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			

			return convertView;
		}

	}
}
