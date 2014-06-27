package com.example.mytest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.provider.ContactsContract.Contacts;

import java.io.InputStream;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ContactsFrame extends ListFragment {
	Context mContext = null;

	/** ��ȡ��Phon���ֶ� **/
	private static final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };

	/** ��ϵ����ʾ���� **/
	private static final int PHONES_DISPLAY_NAME_INDEX = 0;

	/** �绰���� **/
	private static final int PHONES_NUMBER_INDEX = 1;

	/** ͷ��ID **/
	private static final int PHONES_PHOTO_ID_INDEX = 2;

	/** ��ϵ�˵�ID **/
	private static final int PHONES_CONTACT_ID_INDEX = 3;

	/** ��ϵ������ **/
	private ArrayList<String> mContactsName = new ArrayList<String>();

	/** ��ϵ��ͷ�� **/
	private ArrayList<String> mContactsNumber = new ArrayList<String>();

	/** ��ϵ��ͷ�� **/
	private ArrayList<Bitmap> mContactsPhonto = new ArrayList<Bitmap>();

	ListView mListView = null;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		List<Map<String, String>> contacts = null;
		contacts = getPhoneContacts();

		System.out.println("1111111:" + contacts.size());

		for (int i = 0; i < contacts.size(); i++) {

			Map<String, String> value = contacts.get(i);
			String name = value.get("name");
			adapter.add(new SampleItem(name, android.R.drawable.ic_menu_search));

		}

		// for (int i = 0; i < 20; i++) {
		// adapter.add(new SampleItem("Sample List",
		// android.R.drawable.ic_menu_search));
		// }
		setListAdapter(adapter);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������

		super.onCreate(savedInstanceState);

	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		System.out.println("sssssssssss");
		Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
				+ mContactsNumber.get(position)));
		startActivity(dialIntent);
	}

	private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.row1, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon1);
			icon.setImageResource(getItem(position).iconRes);
			// ImageView icon1 = (ImageView) convertView
			// .findViewById(R.id.row_icon1);
			// icon1.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title1);
			title.setText(getItem(position).tag);
			return convertView;
		}

	}

	/**
	 * �õ��ֻ�ͨѶ¼��ϵ����Ϣ
	 * 
	 * @return
	 **/
	private List<Map<String, String>> getPhoneContacts() {

		Map<String, String> contacts = null;

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		ContentResolver resolver = ((MainActivity) getActivity())
				.getContentResolver();

		// ��ȡ�ֻ���ϵ��

		Cursor phoneCursor = resolver.query(Phone.CONTENT_URI,
				PHONES_PROJECTION, null, null, null);

		if (phoneCursor != null) {
			while (phoneCursor.moveToNext()) {
				String phoneNumber = "";
				// �õ��ֻ�����
				try {
					phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
					// ���ֻ�����Ϊ�յĻ���Ϊ���ֶ� ������ǰѭ��
					if (TextUtils.isEmpty(phoneNumber))
						continue;

					// �õ���ϵ������
					String contactName = phoneCursor
							.getString(PHONES_DISPLAY_NAME_INDEX);
					Long contactid = phoneCursor
							.getLong(PHONES_CONTACT_ID_INDEX);

					// System.out.println(contactName + '\n' + phoneNumber);
					contacts = new HashMap<String, String>();

					// ����Map

					contacts.put("name", contactName);

					contacts.put("number", phoneNumber);
					mContactsNumber.add(phoneNumber); 

					list.add(contacts);
				} catch (Exception e) {
					// TODO: handle exception
					continue;
				}
			}

			phoneCursor.close();
		}
		return list;
	}

}
