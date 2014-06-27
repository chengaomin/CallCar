package com.example.mytest;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.example.mytest.R.layout;

public class mapview extends Fragment {


	private MapController mMapController = null;
	BMapManager mBMapMan = null;
	static MapView mMapView = null;
	static mapview newInstance() {	
		mapview f = new mapview();		
        return f;	
		    }
	
	@Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);
	    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        mMapView = (MapView) v.findViewById(R.id.bmapsView);
        mMapController = mMapView.getController();
        mMapView.getController().setZoom(14);
        mMapView.getController().enableClick(true);
        mMapView.setBuiltInZoomControls(true);
        mMapView.refresh();
    	Button button = (Button) v.findViewById(R.id.more);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				((MainActivity) getActivity()).getSlidingMenu().toggle();
			}
		});

		Button button2 = (Button) v.findViewById(R.id.back);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				((MainActivity) getActivity()).getSlidingMenu()
						.showSecondaryMenu();

			}
		});
		LinearLayout ly=(LinearLayout)v.findViewById(R.id.publishReserveBtn);
		ly.setFocusable(true);
		ly.setFocusableInTouchMode(true);
		ly.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setClass(getActivity(), editinfo.class);
				getActivity().startActivity(intent);   

				
			}
		});
//		Button button3=(Button)v.findViewById(R.id.publishReserveBtn);
//		button3.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO 自动生成的方法存根
//			
//				Intent intent=new Intent();
//				intent.setClass(getActivity(), editinfo.class);
//				getActivity().startActivity(intent);   
//
//				
//			}
//		});
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBMapMan = new BMapManager(getActivity().getApplication());
        mBMapMan.init(null);
        
//        setContentView(R.layout.menuitem);  
        // LocationClient just init once;
        // start() is moved
      
    }


    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
//        if (mLocClient != null)
//            mLocClient.stop();
        mMapView.destroy();
        super.onDestroy();
    }

}
