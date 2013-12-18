package com.smeconcept.mopsapp;

//import com.google.api.client.http.HttpExecuteInterceptor;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import java.util.*;
import android.database.sqlite.*;

import android.net.Uri;

import android.app.Activity;
import android.widget.TextClock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Adapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.widget.Toast;
import android.widget.*;
import android.widget.EditText;
import android.provider.AlarmClock;
import android.accounts.OperationCanceledException;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.widget.TextView;
import android.widget.Button;
import android.app.AlarmManager;
import android.accounts.AccountManagerFuture;
import android.view.View;
import java.util.ArrayList;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.content.Intent;
import android.accounts.*;

import android.telephony.SmsMessage;
import android.util.Log;
import android.app.PendingIntent;
import android.os.*;
import android.os.Handler;
import android.os.CountDownTimer;
import android.provider.*;
import android.content.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import org.xml.sax.*;

public class Tracking_Tool extends Activity {
    Spinner s1,s2;
   
    String ava_fr_1;
	String ava_to_1;
	String status_1, status_2;
	String tm_mm;
	Integer hhh1, hhh2, lll1, hhh3,hhh4,lll2;
	
	Integer mmm, upDate;
	Integer punch_hourss1, punch_hourss2, punch_hourss_out1, punch_hourss_out2, punch_hourss3, punch_hourss_out3;
	String presidents1, presidents2, presidents3;
	String report;
	EditText amount1;
	EditText amount2;
	EditText amount3;
	EditText amount4;
	EditText amount5;
	String string_zc1;
	String cur_Time;
	EditText address_nnn;
	EditText input_imp_notes;
	EditText sales;
	EditText team_member_1;
	TextView team_member_2, tm_status_2;
	TextView tt;
	TextView ty;
	TextView punch_tm_out111_info;
	TextView punch_tm_out222_info;
	TextView punch_tm_out333_info;
	
	String important_notes;
	TextView Cur_T;
	String string_punch1;
	TextView punch_hours;
	
	TextView punch_tm111_info, punch_tm222_info, punch_tm333_info;
	Button calculate;
	String calculator;
	Integer hh_punch_tm1, hh_punch_tm2,hh_punch_tm3;
	Cursor c111;
	String eff;
	String string22222s;
	String string11111, string11112, string11113, string11114;
	String    string_imp_notes;
	Button edit1;
	Button start_button_1, start_button_2, start_button_3, finish_button_1, finish_button_2, finish_button_3, lunch_button_1, lunch_button_2, lunch_button_3;
	double x;
	double y;
	double a;
	double b;
	// totsl spent time
	double d;
	// Efficiency
	int rw;
	double z;
	double w;
	double e;
	//shifts <from>, <to>;
	Integer hh1;
	double hh2;
	double hh3;
	double hh4;
	double hh5, hh6, ll3;
	//lunches
	double ll1;
	double ll2;
	//report time
	Integer rtt;
	double hh2_1;
	double hh4_3, hh6_5;
	Integer pick_date1;
	Integer pick_day1;
	Integer ndex_dy;
	Integer hhhh1,hhhh2;
	Integer row_id1, row_id2, row_id3;
	Integer hh_punch_out_tm1, hh_punch_out_tm2, hh_punch_out_tm3;
	Spinner pick_date;
	Integer [] date= {0,
		1,2,3,4,
		5,
		6,
		7,
		8,
		9,
		10,
		11,
		12
	}; 
	Spinner pick_day;
	Integer [] day= {0,
		1,2,3,4,
		5,
		6,
		7,
		8,
		9,
		10,
		11,
		12,
		13,
		14,
		15,
		16,
		17,
		18,
		19,
		20,
		21,
		22,
		23,24, 25,26,27,28,29,30,31
	}; 
	Spinner pick_year;
	Integer [] year= {
		2013, 2014, 2015};
	
	Integer index_dt;
	Integer index_dy;
	Integer index_y;
	Integer ooo, ppp;
	Integer pick_year1;
	Integer sales_db;

	
	DBAdapter db;
	DBContacts DBC2;
	DBTracker DBT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracking);
	
	
	   
		//Current time
		Date dt=new Date();
		int hours_cur=dt.getHours();
		//	rtt=16;
		rtt=hours_cur;
		int minutes_cur=dt.getMinutes();
		cur_Time=hours_cur+":"+minutes_cur;
		final Calendar Cal=Calendar.getInstance();
		Integer hours_local=Cal.get(Calendar.HOUR_OF_DAY);
		Integer minute_local=Cal.get(Calendar.MINUTE);
		
		
		TextView hours_now=(TextView)findViewById(R.id.hours_now);
		//	hours_now.setText(Integer.toString(hours_cur));
		cur_Time=hours_local+":"+minute_local;
		hours_now.setText(cur_Time);

		//Open DBTracker
		// DBT=new DBTracker(this);


		{
			//Open DBC
			DBC2= new DBContacts(this);	
			DBC2.open();

		Cursor c = DBC2.getContact(1);
		if	 (c !=null){
			c.moveToFirst();   

			String string1112s=c.getString(1);
			TextView team_member_1=(TextView)findViewById(R.id.team_member_1);
			team_member_1.setText(string1112s); 

			String string2112s=c.getString(2);
			TextView start_time_1=(TextView)findViewById(R.id.start_time_1);
			start_time_1.setText(string2112s);
			hh1=Integer.parseInt(start_time_1.getText().toString());	

			String string2212s=c.getString(3);
			TextView lunch_time_1=(TextView)findViewById(R.id.lunch_time_1);
			lunch_time_1.setText(string2212s); 
			ll1=Double.parseDouble(lunch_time_1.getText().toString());	

			String string2222s=c.getString(4);
			TextView finish_time_1=(TextView)findViewById(R.id.finish_time_1);
			finish_time_1.setText(string2222s); 
			hh2=Double.parseDouble(finish_time_1.getText().toString());	

			string22222s=c.getString(5);
			TextView tm_status_1=(TextView)findViewById(R.id.tm_status_1);
			tm_status_1.setText(string22222s); 
			status_1=string22222s;
			
			


		} 
		
		Cursor cc = DBC2.getContact(2);
		if	 (cc !=null){
			cc.moveToFirst();   

			String string1112=cc.getString(1);
			TextView team_member_2=(TextView)findViewById(R.id.team_member_2);
			team_member_2.setText(string1112); 

			String string2112=cc.getString(2);
			TextView start_time_2=(TextView)findViewById(R.id.start_time_2);
			start_time_2.setText(string2112);
			hh3=Double.parseDouble(start_time_2.getText().toString());	

			String string2212=cc.getString(3);
			TextView lunch_time_2=(TextView)findViewById(R.id.lunch_time_2);
			lunch_time_2.setText(string2212); 
			ll2=Double.parseDouble(start_time_2.getText().toString());	

			String string2222=cc.getString(4);
			TextView finish_time_2=(TextView)findViewById(R.id.finish_time_2);
			finish_time_2.setText(string2222); 
			hh4=Double.parseDouble(finish_time_2.getText().toString());	

			String string22222=cc.getString(5);
			TextView tm_status_2=(TextView)findViewById(R.id.tm_status_2);
			tm_status_2.setText(string22222); 
			status_2=string22222;


		   

		} 
		
			Cursor ccc = DBC2.getContact(3);
			if	 (ccc !=null){
				ccc.moveToFirst();   

				String string11112=ccc.getString(1);
				TextView team_member_3=(TextView)findViewById(R.id.team_member_3);
				team_member_3.setText(string11112); 

				String string12112=ccc.getString(2);
				TextView start_time_3=(TextView)findViewById(R.id.start_time_3);
				start_time_3.setText(string12112);
				hh5=Double.parseDouble(start_time_3.getText().toString());	

				String string12212=ccc.getString(3);
				TextView lunch_time_3=(TextView)findViewById(R.id.lunch_time_3);
				lunch_time_3.setText(string12212); 
				ll3=Double.parseDouble(start_time_3.getText().toString());	

				String string12222=ccc.getString(4);
				TextView finish_time_3=(TextView)findViewById(R.id.finish_time_3);
				finish_time_3.setText(string12222); 
				hh6=Double.parseDouble(finish_time_3.getText().toString());	

				String string122222=ccc.getString(5);
				TextView tm_status_3=(TextView)findViewById(R.id.tm_status_3);
				tm_status_3.setText(string122222); 


				Button punch_out2=(Button)findViewById(R.id.punch_out2);
				punch_out2.setOnClickListener(new Button.OnClickListener()

					{public void onClick

						(View v) { 
						
							//Current time
							Date punch_date1=new Date();
							int punch_hours1=punch_date1.getHours();
							int punch_minutes1=punch_date1.getMinutes();
							String punch_time1=punch_hours1+":"+punch_minutes1;
							TextView punch_hours_tm2=(TextView)findViewById(R.id.punch_hours_tm2);

							//	hours_now.setText(Integer.toString(hours_cur));

							punch_hours_tm2.setText(punch_time1);
							Double mm2=hh3-punch_hours1;
							String tm_mm2=mm2+"hrs late";
							TextView punch_tm2_info=(TextView)findViewById(R.id.punch_tm2_info);
							punch_tm2_info.setText(tm_mm2);

						}});

			} 
		
					
			
		
			lunch_button_1=(Button)findViewById(R.id.lunch_button_1);
			lunch_button_1.setOnClickListener(new Button.OnClickListener()
				{public void onClick

					(View v) { 
						lunch_button_1.setVisibility(View.INVISIBLE);


					}});

			lunch_button_2=(Button)findViewById(R.id.lunch_button_2);
			lunch_button_2.setOnClickListener(new Button.OnClickListener()
				{public void onClick

					(View v) { 
						lunch_button_2.setVisibility(View.INVISIBLE);


					}});
					
			
					
			lunch_button_3=(Button)findViewById(R.id.lunch_button_3);
			lunch_button_3.setOnClickListener(new Button.OnClickListener()
				{public void onClick

					(View v) { 
						lunch_button_3.setVisibility(View.INVISIBLE);


					}});
					
			finish_button_3=(Button)findViewById(R.id.finish_button_3);
			finish_button_3.setOnClickListener(new Button.OnClickListener()
				{public void onClick

					(View v) { 
						finish_button_3.setVisibility(View.INVISIBLE);


					}});
			
		
		pick_date = (Spinner) findViewById(R.id.pick_date);
		ArrayAdapter<Integer> adapter_date = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, date);
		pick_date.setAdapter(adapter_date);

		pick_date.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
					index_dt= pick_date.getSelectedItemPosition();
					pick_date1=date[index_dt];
					
					pick_day = (Spinner) findViewById(R.id.pick_day);
					ArrayAdapter<Integer> adapter_day = new ArrayAdapter<Integer>(
						getBaseContext(), android.R.layout.simple_spinner_item, day);
					pick_day.setAdapter(adapter_day);

					pick_day.setOnItemSelectedListener(new OnItemSelectedListener() {
							public void onItemSelected(AdapterView<?> arg0, View arg1, 
													   int arg2, long arg3) {
								index_dy= pick_day.getSelectedItemPosition();
								pick_day1=day[index_dy];
								

								pick_year = (Spinner) findViewById(R.id.pick_year);
								ArrayAdapter<Integer> adapter_year = new ArrayAdapter<Integer>(
									getBaseContext(), android.R.layout.simple_spinner_item, year);
								pick_year.setAdapter(adapter_year);

								pick_year.setOnItemSelectedListener(new OnItemSelectedListener() {
										public void onItemSelected(AdapterView<?> arg0, View arg1, 
																   int arg2, long arg3) {
											index_y= pick_year.getSelectedItemPosition();
											pick_year1=year[index_y];
								
											
			
					//--get all contacts---        
					DBC2.open();
					Cursor ccc = DBC2.getAllContacts();
					if (ccc.moveToFirst())
					{
						do {
							//  DisplayContact(c);
						    String mm=ccc.getString(6);
							Integer mmm=Integer.parseInt(mm.toString());	

							String dd=ccc.getString(7);
							Integer ddd=Integer.parseInt(dd.toString());

							String yy=ccc.getString(8);
							Integer yyy=Integer.parseInt(yy.toString());
							Integer nnn;

							nnn=pick_date1-mmm;
							ooo=pick_day1-ddd;
							ppp=pick_year1-yyy;
							//String date=mmm+"/"+ddd+"/"+yyy;
							
						   if ((ooo==0)&&(nnn==0)&&(ppp==0)){upDate=1;
												
							Toast.makeText(getBaseContext(), "Dates in the DB: "+mmm + " / " + ddd + " / "+ yyy +" : "+ upDate, Toast.LENGTH_SHORT).show();
							 
							    c111=ccc;
								
							    String string_row1=ccc.getString(0);
								TextView punch_tm1111_info=(TextView)findViewById(R.id.punch_tm111_info);
								punch_tm1111_info.setText(string_row1); 
								row_id1=Integer.parseInt(punch_tm1111_info.getText().toString());
								
								String string1112s=ccc.getString(1);
								presidents1=string1112s;
								TextView team_member_1=(TextView)findViewById(R.id.team_member_1);
								team_member_1.setText(string1112s); 

								String string2112s=ccc.getString(2);
								TextView start_time_1=(TextView)findViewById(R.id.start_time_1);
								start_time_1.setText(string2112s);
								hh1=Integer.parseInt((start_time_1.getText().toString()));	
								hhh1=Integer.parseInt(start_time_1.getText().toString());

								String string2212s=ccc.getString(3);
								TextView lunch_time_1=(TextView)findViewById(R.id.lunch_time_1);
								lunch_time_1.setText(string2212s); 
								ll1=Double.parseDouble(lunch_time_1.getText().toString());	
						        lll1=Integer.parseInt(lunch_time_1.getText().toString());

								String string2222s=ccc.getString(4);
								TextView finish_time_1=(TextView)findViewById(R.id.finish_time_1);
								finish_time_1.setText(string2222s); 
								hh2=Double.parseDouble(finish_time_1.getText().toString());	
						        hhh2=Integer.parseInt(finish_time_1.getText().toString());

								String string22222s=ccc.getString(5);
								TextView tm_status_1=(TextView)findViewById(R.id.tm_status_1);
								tm_status_1.setText(string22222s); 
								
								String string_punch1=ccc.getString(9);
								punch_tm111_info=(TextView)findViewById(R.id.punch_tm111_info);
								punch_tm111_info.setText(string_punch1); 
								hh_punch_tm1=Integer.parseInt(punch_tm111_info.getText().toString());
								if(hh_punch_tm1>0){
					         	TextView punch_tm11_info=(TextView)findViewById(R.id.punch_tm11_info);
						        punch_tm11_info.setText(string_punch1);}
								else
								{	}
        						
								String string_punch_out1=ccc.getString(11);
								punch_tm_out111_info=(TextView)findViewById(R.id.punch_tm_out111_info);
								punch_tm_out111_info.setText(string_punch_out1); 
								hh_punch_out_tm1=Integer.parseInt(punch_tm_out111_info.getText().toString());
						        if(hh_punch_out_tm1>0){
						        TextView punch_out_tm11_info=(TextView)findViewById(R.id.punch_out_tm11_info);
						        punch_out_tm11_info.setText(string_punch_out1);}
														
						       //to show "important notes"
						      string_imp_notes=ccc.getString(12);
						       EditText input_imp_notes =(EditText)findViewById(R.id.input_imp_notes);
						       input_imp_notes.setText(string_imp_notes); 
								
								ccc.moveToNext();
								
								// Toast.makeText(getBaseContext(), "Dates in the DB: "+mmm + " / " + ddd + " / "+ yyy +" : "+ upDate, Toast.LENGTH_SHORT).show();


								String string_row2=ccc.getString(0);
								TextView punch_tm2222_info=(TextView)findViewById(R.id.punch_tm222_info);
								punch_tm2222_info.setText(string_row2); 
								row_id2=Integer.parseInt(punch_tm2222_info.getText().toString());
								
								
								String string11112s=ccc.getString(1);
								team_member_2=(TextView)findViewById(R.id.team_member_2);
								presidents2=string11112s;
								team_member_2.setText(string11112s); 

								String string21112s=ccc.getString(2);
								TextView start_time_2=(TextView)findViewById(R.id.start_time_2);
								start_time_2.setText(string21112s);
								hh3=Double.parseDouble(start_time_2.getText().toString());	
								hhh3=Integer.parseInt(start_time_2.getText().toString());

								String string22112s=ccc.getString(3);
								TextView lunch_time_2=(TextView)findViewById(R.id.lunch_time_2);
								lunch_time_2.setText(string22112s); 
								ll2=Double.parseDouble(lunch_time_2.getText().toString());	
								lll2=Integer.parseInt(lunch_time_2.getText().toString());

								String string22122s=ccc.getString(4);
								TextView finish_time_2=(TextView)findViewById(R.id.finish_time_2);
								finish_time_2.setText(string22122s); 
								hh4=Double.parseDouble(finish_time_2.getText().toString());	
								hhh4=Integer.parseInt(finish_time_2.getText().toString());

								String string222122s=ccc.getString(5);
								TextView tm_status_2=(TextView)findViewById(R.id.tm_status_2);
								tm_status_2.setText(string222122s); 
								
						        String string_punch2=ccc.getString(9);
						        punch_tm222_info=(TextView)findViewById(R.id.punch_tm222_info);
						        punch_tm222_info.setText(string_punch2); 
						        hh_punch_tm2=Integer.parseInt(punch_tm222_info.getText().toString());
						        if(hh_punch_tm2>0){
						        TextView punch_tm22_info=(TextView)findViewById(R.id.punch_tm22_info);
						        punch_tm22_info.setText(string_punch2);}
								
								String string_punch_out2=ccc.getString(11);
								punch_tm_out222_info=(TextView)findViewById(R.id.punch_tm_out222_info);
								punch_tm_out222_info.setText(string_punch_out2); 
								hh_punch_out_tm2=Integer.parseInt(punch_tm_out222_info.getText().toString());
								if(hh_punch_out_tm2>0){
								TextView punch_out_tm22_info=(TextView)findViewById(R.id.punch_out_tm22_info);
								punch_out_tm22_info.setText(string_punch_out2);}
								
								
						     	ccc.moveToNext();

							/*	Toast.makeText(getBaseContext(), "Dates in the DB: "+mmm + " / " + ddd + " / "+ yyy +" : "+ upDate, Toast.LENGTH_SHORT).show();

								String string_row3=ccc.getString(0);
								TextView punch_tm3333_info=(TextView)findViewById(R.id.punch_tm333_info);
								punch_tm3333_info.setText(string_row3); 
								row_id3=Integer.parseInt(punch_tm3333_info.getText().toString());
								
							*/	
								String string1_2s=ccc.getString(1);
								presidents3=string1_2s;
								TextView team_member_3=(TextView)findViewById(R.id.team_member_3);
								team_member_3.setText(string1_2s); 

								String string2_2s=ccc.getString(2);
								TextView start_time_3=(TextView)findViewById(R.id.start_time_3);
								start_time_3.setText(string2_2s);
								hh5=Double.parseDouble(start_time_3.getText().toString());	

								String string2_3s=ccc.getString(3);
								TextView lunch_time_3=(TextView)findViewById(R.id.lunch_time_3);
								lunch_time_3.setText(string2_3s); 
								ll3=Double.parseDouble(lunch_time_3.getText().toString());	

								/* String string2_4s=ccc.getString(4);
								TextView finish_time_3=(TextView)findViewById(R.id.finish_time_3);
								finish_time_3.setText(string2_4s); 
								hh6=Double.parseDouble(finish_time_3.getText().toString());	

								String string2_5s=ccc.getString(5);
								TextView tm_status_3=(TextView)findViewById(R.id.tm_status_3);
								tm_status_3.setText(string2_5s); 
								
								String string_punch3=ccc.getString(9);
						        punch_tm333_info=(TextView)findViewById(R.id.punch_tm333_info);
						        punch_tm333_info.setText(string_punch3); 
						        hh_punch_tm3=Integer.parseInt(punch_tm333_info.getText().toString());
						        if(hh_punch_tm3>0){
						        TextView punch_tm33_info=(TextView)findViewById(R.id.punch_tm33_info);
						        punch_tm33_info.setText(string_punch3);}
								
								String string_punch_out3=ccc.getString(11);
								punch_tm_out333_info=(TextView)findViewById(R.id.punch_tm_out333_info);
								punch_tm_out333_info.setText(string_punch_out3); 
								hh_punch_out_tm3=Integer.parseInt(punch_tm_out333_info.getText().toString());
						        if(hh_punch_out_tm3>0){
								TextView punch_out_tm33_info=(TextView)findViewById(R.id.punch_out_tm33_info);
								punch_out_tm33_info.setText(string_punch_out3);}
								
							*/
								
								ccc.moveToLast();
								}
								else
								{
									
									// EditText input_imp_notes =(EditText)findViewById(R.id.input_imp_notes);
									// input_imp_notes.setText("choose the other date or return to Schedule"); 
									
									
									
								} 


						} while (ccc.moveToNext());
						}
						else{
							
						}
						
						//DBC2.close();
						
						

					start_button_1=(Button)findViewById(R.id.start_button_1);
						
						start_button_1.setOnClickListener(new Button.OnClickListener()

							
							{public void onClick


								(View v) { 
									
									start_button_1.setVisibility(View.INVISIBLE);
									
									if(hh_punch_tm1==0){
											
									//Current time
									Date punch_date=new Date();
								    Integer punch_hours=punch_date.getHours();
									punch_hourss1=punch_hours;
									int punch_minutes=punch_date.getMinutes();
									String punch_time=punch_hours+":"+punch_minutes;
									String punch_hours_1=" :"+punch_hours;
									TextView punch_hours_tm1=(TextView)findViewById(R.id.punch_hours_tm1);

									//	hours_now.setText(Integer.toString(hours_cur));

									punch_hours_tm1.setText(punch_time);
									Integer mm1=hh1-punch_hours;
									String tm_mm1=mm1+"hrs late";
									TextView punch_tm1_info=(TextView)findViewById(R.id.punch_tm1_info);
									punch_tm1_info.setText(tm_mm1);
									TextView punch_tm11_info=(TextView)findViewById(R.id.punch_tm11_info);
									punch_tm11_info.setText(punch_hours_1);
									
									DBC2.open();
									
										if (DBC2.updatePunchIn(row_id1, punch_hours))
										Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
									else
										Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();
									
		
									DBC2.close();}
									else
									{
									
										}
									
									{
								
										punch_tm111_info=(TextView)findViewById(R.id.punch_tm11_info);
								
									
									DBC2.close();
									
										}

								}});
								
								
						start_button_2=(Button)findViewById(R.id.start_button_2);
						start_button_2.setOnClickListener(new Button.OnClickListener()

							{public void onClick


								(View v) { 
									start_button_2.setVisibility(View.INVISIBLE);

									if((hh_punch_tm2)==0){

										//Current time
										Date punch_date=new Date();
										int punch_hours=punch_date.getHours();
										punch_hourss2=punch_hours;
										int punch_minutes=punch_date.getMinutes();
										String punch_time=punch_hours+":"+punch_minutes;
										String punch_hours_out2=" :"+punch_hours;
										TextView punch_hours_tm2=(TextView)findViewById(R.id.punch_hours_tm2);

										//	hours_now.setText(Integer.toString(hours_cur));

										punch_hours_tm2.setText(punch_time);
										Double mm2=hh2-punch_hours;
										String tm_mm2=mm2+"hrs late";
										TextView punch_tm2_info=(TextView)findViewById(R.id.punch_tm2_info);
										punch_tm2_info.setText(tm_mm2);
										TextView punch_tm22_info=(TextView)findViewById(R.id.punch_tm22_info);
										punch_tm22_info.setText(punch_hours_out2);

										DBC2.open();

										if (DBC2.updateContact(row_id2, presidents2, hhh3,lll2, hhh4,status_2, pick_date1, pick_day1, pick_year1, punch_hours, 0,0, ""))
											Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
										else
											Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();


										DBC2.close();}
									else
									{
										Toast.makeText(getBaseContext(), "Already punch in before.", Toast.LENGTH_LONG).show();
									}
									{

										punch_tm222_info=(TextView)findViewById(R.id.punch_tm22_info);


										DBC2.close();
									}

								}});
								
								/////
						finish_button_1=(Button)findViewById(R.id.finish_button_1);
						finish_button_1.setOnClickListener(new Button.OnClickListener()
							{public void onClick

								(View v) { 
									finish_button_1.setVisibility(View.INVISIBLE);
									
						if((hh_punch_out_tm1)==0){

						//Current time
						Date punch_date=new Date();
						int punch_hours=punch_date.getHours();
						punch_hourss_out1=punch_hours;
						int punch_minutes=punch_date.getMinutes();
						String punch_time=punch_hours+":"+punch_minutes;
						String punch_hours_1=" :"+punch_hours;
						TextView punch_hours_out_tm1=(TextView)findViewById(R.id.punch_hours_tm1);
						punch_hours_out_tm1.setText(punch_time);
						Double mm1=hh2-punch_hours;
						String tm_mm1=mm1+"hrs over";
						TextView punch_tm1_info=(TextView)findViewById(R.id.punch_tm1_info);
						punch_tm1_info.setText(tm_mm1);
						TextView punch_tm_out11_info=(TextView)findViewById(R.id.punch_tm_out11_info);
						punch_tm_out11_info.setText(punch_hours_1);

						DBC2.open();

						if (DBC2.updatePunchOut(row_id1, punch_hours))
						Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
						else
						Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();


						DBC2.close();}
						else
						{
						Toast.makeText(getBaseContext(), "Already punch in before.", Toast.LENGTH_LONG).show();
						}
						{

					//	punch_tm111_info=(TextView)findViewById(R.id.punch_tm11_info);


						DBC2.close();

						}

						}});
										

						finish_button_2=(Button)findViewById(R.id.finish_button_2);
						finish_button_2.setOnClickListener(new Button.OnClickListener()
						{public void onClick

						(View v) { 
						finish_button_2.setVisibility(View.INVISIBLE);

						if((hh_punch_out_tm2)==0){

												//Current time
												Date punch_out_date2=new Date();
												int punch_out_hours_2=punch_out_date2.getHours();
												punch_hourss_out2=punch_out_hours_2;
												int punch_minutes=punch_out_date2.getMinutes();
												String punch_out_time=punch_out_hours_2+":"+punch_minutes;
												String punch_hours_2=" :"+punch_out_hours_2;
												TextView punch_hours_out_tm2=(TextView)findViewById(R.id.punch_hours_tm2);
												punch_hours_out_tm2.setText(punch_out_time);
												Double mm2=hh4-punch_out_hours_2;
												String tm_mm2=mm2+"hrs over";
												TextView punch_tm2_info=(TextView)findViewById(R.id.punch_tm2_info);
												punch_tm2_info.setText(tm_mm2);
												TextView punch_tm_out22_info=(TextView)findViewById(R.id.punch_tm_out22_info);
												punch_tm_out22_info.setText(punch_hours_2);

												DBC2.open();

												if (DBC2.updatePunchOut(row_id2, punch_out_hours_2))
													Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
												else
													Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();


												DBC2.close();}
											else
											{
												Toast.makeText(getBaseContext(), "Already punch in before.", Toast.LENGTH_LONG).show();
											}
											{

												//	punch_tm111_info=(TextView)findViewById(R.id.punch_tm11_info);


												DBC2.close();

											}

										}});
										
				////
										start_button_3=(Button)findViewById(R.id.start_button_3);
										start_button_3.setOnClickListener(new Button.OnClickListener()

										{public void onClick


										(View v) { 
											start_button_3.setVisibility(View.INVISIBLE);

											if((hh_punch_tm3)==0){

												//Current time
												Date punch_date=new Date();
												int punch_hours=punch_date.getHours();
												punch_hourss3=punch_hours;
												int punch_minutes=punch_date.getMinutes();
												String punch_time=punch_hours+":"+punch_minutes;
												String punch_hours_out3=" :"+punch_hours;
												TextView punch_hours_tm3=(TextView)findViewById(R.id.punch_hours_tm3);

												//	hours_now.setText(Integer.toString(hours_cur));

												punch_hours_tm3.setText(punch_time);
												Double mm3=hh3-punch_hours;
												String tm_mm3=mm3+"hrs late";
												TextView punch_tm3_info=(TextView)findViewById(R.id.punch_tm3_info);
												punch_tm3_info.setText(tm_mm3);
												TextView punch_tm33_info=(TextView)findViewById(R.id.punch_tm33_info);
												punch_tm33_info.setText(punch_hours_out3);

												DBC2.open();
												
												if (DBC2.updatePunchIn(row_id3, punch_hours))
										
													Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
												else
													Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();


												DBC2.close();}
											else
											{
												Toast.makeText(getBaseContext(), "Already punch in before.", Toast.LENGTH_LONG).show();
											}
											{

												punch_tm333_info=(TextView)findViewById(R.id.punch_tm33_info);


												DBC2.close();
											}

										}});
										
											finish_button_3=(Button)findViewById(R.id.finish_button_3);
											finish_button_3.setOnClickListener(new Button.OnClickListener()
												{public void onClick

													(View v) { 
														finish_button_3.setVisibility(View.INVISIBLE);

														if((hh_punch_out_tm3)==0){

															//Current time
															Date punch_out_date3=new Date();
															int punch_out_hours_3=punch_out_date3.getHours();
															punch_hourss_out3=punch_out_hours_3;
															int punch_minutes=punch_out_date3.getMinutes();
															String punch_out_time=punch_out_hours_3+":"+punch_minutes;
															String punch_hours_3=" :"+punch_out_hours_3;
															TextView punch_hours_out_tm3=(TextView)findViewById(R.id.punch_hours_tm3);
															punch_hours_out_tm3.setText(punch_out_time);
															Double mm3=hh6-punch_out_hours_3;
															String tm_mm3=mm3+"hrs over";
															TextView punch_tm3_info=(TextView)findViewById(R.id.punch_tm3_info);
															punch_tm3_info.setText(tm_mm3);
															TextView punch_tm_out33_info=(TextView)findViewById(R.id.punch_tm_out33_info);
															punch_tm_out33_info.setText(punch_hours_3);

															DBC2.open();

															if (DBC2.updatePunchOut(row_id3, punch_out_hours_3))
																Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
															else
																Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();


															DBC2.close();}
														else
														{
															Toast.makeText(getBaseContext(), "Already punch in before.", Toast.LENGTH_LONG).show();
														}
														{

															//	punch_tm111_info=(TextView)findViewById(R.id.punch_tm11_info);


															DBC2.close();

														} 

													}});
										}

				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});}
			
	            public void onNothingSelected(AdapterView<?> arg0) {
	            } 
             });}
			
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});
		

			Button sms=(Button)findViewById(R.id.sms);
			sms.setOnClickListener(new Button.OnClickListener()

				{public void onClick


					(View v) {
						
						}});
	
			Button scheduler=(Button)findViewById(R.id.scheduler);
			scheduler.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						Intent jj=new Intent(Tracking_Tool.this,MainActivity.class);
						startActivity(jj);
						finish();
						}
						});
      
	  //TextView from database
			//   AddContact();
			// GetContacts();}}
			GetContact();}}
		//	UpdateContact();
			//   DeleteContact();
		
				
				public void GetContacts() {
					//--get all contacts---        
					DBC2.open();
					Cursor c = DBC2.getAllContacts();
					if (c.moveToFirst())
					{
						do {
							DisplayContact(c);
						} while (c.moveToNext());
					}
					DBC2.close();
				}
				
	

				public void GetContact() {
					//---get a contact---
					DBC2.open();
					Cursor c = DBC2.getContact(1);
					if (c.moveToFirst())        
						DisplayContact(c);
					else
						Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
					DBC2.close();
				}

				public void UpdateContact() {
					//---update a contact---
					DBC2.open();
					if (DBC2.updateContact(1, "John", 8,12, 16,"GR", 9, 28, 2013, 8,12,16,""))
						Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
					DBC2.close();

					DBC2.open();
					if (DBC2.updateContact(2, "Adam", 8,12, 16,"GR", 9, 28,2013, 8,12,16,""))
						Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
					DBC2.close();

					DBC2.open();
					if (DBC2.updateContact(3, "Kristal", 8,12, 16,"GR",9,29,2013,8,12,16,""))
						Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
					DBC2.close();
				}

				public void DeleteContact() {
					DBC2.open();
					if (DBC2.deleteContact(1))
						Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
					DBC2.close();
				}

				public void DisplayContact(Cursor c)
				{
					Toast.makeText(this,
								   "id: " + c.getString(0) + "\n" +
								   "Name: " + c.getString(1) + "\n" +
								   "starts:  " + c.getString(2) + "\n"+
								   "status:  "+c.getString(5),
								   Toast.LENGTH_LONG).show();
				

					
			

	


//		sales=(EditText)findViewById(R.id.sales);
//		d=Double.parseDouble(sales.getText().toString());


	   	sales=(EditText)findViewById(R.id.sales);
		
		tt=(TextView)findViewById(R.id.tt);
		ty=(TextView)findViewById(R.id.ty);

		calculate=(Button)findViewById(R.id.calculate);
		calculate.setOnClickListener(new Button.OnClickListener()

			{public void onClick

				(View v) { 
					

		// TM's hours
		{ 	
		
			
		//exception when punched in 24:00. For the case need not to put "0" in the 9th column by default.
		/*
			if ((rtt<punch_hourss2)&&(rtt>punch_hourss1))
			{	hh2_1=rtt-punch_hourss1; }

			else

			if ((rtt<punch_hourss1)&&(rtt<punch_hourss2))
			{	hh2_1=0; }	

			else*/
			


			if
			(hh_punch_tm1!=0){
				punch_hourss1=hh_punch_tm1;
			}
			
			
			if
			((hh_punch_out_tm1!=0)){
				punch_hourss_out1=hh_punch_out_tm1;
			}

			if
			((hh_punch_out_tm1==0)){
				punch_hourss_out1=rtt;
			}
			
			if((punch_hourss1==null)&&(hh_punch_tm1==0)){
				hh2_1=0;
			}
			else if
			((hh_punch_tm1>hh_punch_out_tm1)||(punch_hourss1>hh_punch_out_tm1))
			
			{
				{    hh2_1=punch_hourss_out1-punch_hourss1+24;}
			}
			else

			
			{    hh2_1=punch_hourss_out1-punch_hourss1;}


			Toast.makeText(getBaseContext(), "punch_hourss1 : "+ punch_hourss1 + "; "+"punch_hourss2 : "+punch_hourss2+" ; " + "rtt : " +rtt + "hh21 : "+ hh2_1, Toast.LENGTH_SHORT).show();

			

			// Second TM
			
			if
			(hh_punch_tm2!=0){
				punch_hourss2=hh_punch_tm2;
			}


			if
			((hh_punch_out_tm2!=0)){
				punch_hourss_out2=hh_punch_out_tm2;
			}

			if
			((hh_punch_out_tm2==0)){
				punch_hourss_out2=rtt;
			}

			if((punch_hourss2==null)&&(hh_punch_tm2==0)){
				hh4_3=0;
			}
			else if
			((hh_punch_tm2>hh_punch_out_tm2)||(punch_hourss2>hh_punch_out_tm2))

			{
				{    hh4_3=punch_hourss_out2-punch_hourss2+24;}
			}
			else


			{    hh4_3=punch_hourss_out2-punch_hourss2;}
			
			////
		/*	if ((hh4<hh3)||(hh4==hh3)||(rtt==hh3))
			{ hh4_3=0;}

			else

			if ((rtt<hh4)&&(rtt>hh3))		
			{	hh4_3=rtt-hh3;	}

			else

			if ((rtt<hh3)&&(rtt<hh4))
			{	hh4_3=0;	}

			else

			{	hh4_3=hh4-hh3; }


			// lunches
			if ((hh1>ll1)||(hh2<ll1)||(ll1==0)||(rtt<ll1))
			{ll1=0;}   

			else 
			{ll1=1;} 

			if ((hh3>ll2)||(hh4<ll2)||(ll2==0)||(rtt<ll2))
			{ll2=0;}
	//			  Toast.makeText(getBaseContext(),
	//		 "You have selected wrong lunch ", 
	//		 Toast.LENGTH_SHORT).show();} 
			else 
			{ll2=1;} 
*/
			//Third TM
			
			if
			(hh_punch_tm3!=0){
				punch_hourss3=hh_punch_tm3;
			}


			if
			((hh_punch_out_tm3!=0)){
				punch_hourss_out3=hh_punch_out_tm3;
			}

			if
			((hh_punch_out_tm3==0)){
				punch_hourss_out3=rtt;
			}

			if((punch_hourss3==null)&&(hh_punch_tm3==0)){
				hh6_5=0;
			}
			else if
			((hh_punch_tm3>punch_hourss_out3)||(punch_hourss3>punch_hourss_out3))

			{
				{    hh6_5=punch_hourss_out3-punch_hourss3+24;}
			}
			else


			{    hh6_5=punch_hourss_out3-punch_hourss3;}
			

		z=hh2_1+hh4_3+hh6_5-ll1-ll2-ll3;
	        
	}


								if( !sales.getText().toString().equals("")&&
								   sales.getText().toString().length()>0) {

									d=Double.parseDouble(sales.getText().toString());
									sales_db=Integer.parseInt(sales.getText().toString());
								}

								else
									d=0;
        
		
	    w=d/z;
	    
		double rw=Math.ceil(w*100)/100;

		tt.setText(Double.toString(z));
		ty.setText(Double.toString(rw));
		
		eff=rw+"$/hr";
        
	
	
								
	}
	
	});
				
					 Button save_db=(Button)findViewById(R.id.save_db);
					 save_db.setOnClickListener(new Button.OnClickListener()

					 {public void onClick

					 (View v) { 
					 DBC2.open();

					 input_imp_notes=(EditText)findViewById(R.id.input_imp_notes);

					 String str=input_imp_notes.getText().toString();
					 report=cur_Time  +":"+ "  "+str;

					 if (DBC2.updateReport(row_id1, report))
					 Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
					 else
					 Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();


					 DBC2.close();}
					 });
					 
						

					Button mail_tm=(Button)findViewById(R.id.mail_tm);

					mail_tm.setOnClickListener(new View.OnClickListener() {

							public void onClick (View v) 

							{


								Intent j=new Intent(Intent.ACTION_SEND);
								j.setData(Uri.parse("mailto:"));
								String[] to={"igorkulishov@gmail.com"};
								j.putExtra(Intent.EXTRA_EMAIL, to);			
								j.putExtra(Intent.EXTRA_SUBJECT,"Subject");
								j.putExtra(Intent.EXTRA_TEXT, "efficiency is" + eff + report);			
								j.setType("message/rfc822");
								startActivity(Intent.createChooser(j,"Email"));
							}
						}
					);			
					

					Button sms=(Button)findViewById(R.id.sms);

					sms.setOnClickListener(new View.OnClickListener() {

							public void onClick (View v) 

							{


								Intent j=new Intent(Intent.ACTION_SEND);
								
								j.setType("text/plain");
			
								j.putExtra(Intent.EXTRA_SUBJECT,"Subject");
								j.putExtra(Intent.EXTRA_TEXT, "efficiency is" + eff + "   " + report);			
								
								startActivity(Intent.createChooser(j,"Message"));
							}
						}
					);		
					
	}
	
	
/*
	public class SMSReceiver extends BroadcastReceiver
	{
		@Override
		public void onReceive(Context context, Intent intent)
		{
			//---get the SMS message passed in---
			Bundle bundle = intent.getExtras();
			SmsMessage[] msgs = null;
			String str = "SMS from ";
			if (bundle != null)
			{
				//---retrieve the SMS message received---
				Object[] pdus = (Object[]) bundle.get("pdus");
				msgs = new SmsMessage[pdus.length];
				for (int i=0; i<msgs.length; i++){
					msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
					if (i==0) {
						//---get the sender address/phone number---
						str += msgs[i].getOriginatingAddress();
						str += ": ";
					} 
					//---get the message body---
					str += msgs[i].getMessageBody().toString();       
					EditText input_imp_notes =(EditText)findViewById(R.id.input_imp_notes1);
				 	input_imp_notes.setText(str); 
				}
				//---display the new SMS message---
				Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

				//---prevent this SMS message from being broadcasted---
				abortBroadcast();
				Log.d("SMSReceiver", str);    
				  
			}
		}
		
	}
	
	public void SetAlarm(){
	BroadcastReceiver receiver = new BroadcastReceiver(){
		@Override
		public void onReceive(Context context, Intent intent)
		{
			Toast.makeText(getBaseContext(), "Alarm successful.", Toast.LENGTH_LONG).show();
			
		
			EditText input_imp_notes =(EditText)findViewById(R.id.input_imp_notes);
			input_imp_notes.setText(string_imp_notes); 
			
			context.unregisterReceiver(this);
		}
		};
		
		this.registerReceiver(receiver,new IntentFilter( "com.smeconcept.mopsapp.somemessage"));
		PendingIntent pintent = PendingIntent.getBroadcast(this,0, new Intent("com.smeconcept.mopsapp.somemessage"),0);
	AlarmManager manager=(AlarmManager)(this.getSystemService(Context.ALARM_SERVICE));
	manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime()+1000*10,pintent);
	
	}
	
	
	
	//////// verifing Google App ID exists
	
	
	
	
	////////
	
	

	/////// receipt to check email
	
	/*GoogleCredential credential=new GoogleCredential();
	com.google.api.services.tasks.Tasks service;
	
	AccountManager am = AccountManager.get(this);
	Account[] accounts = accountManager.getAccountsByType("com.google"); 
	String AUTH_TOKEN_TYPE = "oauth2:https://www.googleapis.com/auth/analytics.readonly";
	am.getAuthToken(accounts[0], AUTH_TOKEN_TYPE, null, this, new AccountManagerCallback<Bundle>()
	{ public void run(AccountManagerFuture<Bundle> future)
	{ try { String token = future.getResult().getString(AccountManager.KEY_AUTHTOKEN); 
	System.out.println("token " + token);
	} catch (...) {}

	} },  
	null);*/
	
	///////
	//// retrieve emails:
	
	
	
	
	
	// Get the account list, and pick the first one 
/*{ final String ACCOUNT_TYPE_GOOGLE = "com.google";
	final String[] FEATURES_MAIL = { "service_mail" };
	AccountManager.get(this).getAccountsByTypeAndFeatures(ACCOUNT_TYPE_GOOGLE, FEATURES_MAIL,
	new AccountManagerCallback()
	{
	@Override
	public void run(AccountManagerFuture future) 
	{ 
	Account[] accounts = null;
	try { accounts = future.getResult();
	if (accounts != null && accounts.length > 0)
		{ String selectedAccount = accounts[0].name;
	queryLabels(selectedAccount);
	
	}

		}
		catch (OperationCanceledException oce) { 
		// TODO: handle exception 
		} catch (IOException ioe) { 
		// TODO: handle exception
		} catch (AuthenticatorException ae) { 
		// TODO: handle exception
		} } }, null 
		// handler 
		);}
		
		public void queryLabels(){ String account="igorkulishov@gmail.com";
		Uri LABELS_URI = Uri.parse("content://gmail-ls/labels/"); 
		Uri ACCOUNT_URI = Uri.withAppendedPath(LABELS_URI, account); 
		ContentResolver contentResolver=myActivity.getContentResolver();
		Cursor cursor = contentResolver.query(ACCOUNT_URI, null, null, null, null);

//iterate over all labels in the account if (cursor.moveToFirst()) { int unreadColumn = cursor.getColumnIndex(LabelColumns.NUM_UNREAD_CONVERSATIONS); 
		int nameColumn = cursor.getColumnIndex(LabelColumns.NAME); 
		do { String name = cursor.getString(nameColumn); 
		String unread = cursor.getString(unreadColumn);
		//here's the value you need } while (cursor.moveToNext()); } }
		}*/
	
	////////

/*          private String DownloadText(String URL) {
			int BUFFER_SIZE = 2000;
			InputStream in = null;
			try {			
				//in = OpenHttpGETConnection(URL);
				in = OpenHttpPOSTConnection(URL);
			} catch (Exception e) {
				Log.d("Networking", e.getLocalizedMessage());
				return "";
			}

			InputStreamReader isr = new InputStreamReader(in);
			int charRead;
			String str = "";
			char[] inputBuffer = new char[BUFFER_SIZE];
			try {
				while ((charRead = isr.read(inputBuffer)) > 0) {
					// ---convert the chars to a String---
					String readString = String
						.copyValueOf(inputBuffer, 0, charRead);
					str += readString;
					inputBuffer = new char[BUFFER_SIZE];
				}
				in.close();
			} catch (IOException e) {
				Log.d("Networking", e.getLocalizedMessage());
				return "";
			}
			return str;		
		}

		private class DownloadTextTask extends AsyncTask<String, Void, String> {
			protected String doInBackground(String... urls) {
				return DownloadText(urls[0]);
			}

			@Override
			protected void onPostExecute(String result) {
				Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
				Log.d("DownloadTextTask", result);
				
				EditText input_imp_notes =(EditText)findViewById(R.id.input_imp_notes);
				input_imp_notes.setText(result); 
				
			}
		}

		// ---Connects using HTTP GET---
		public InputStream OpenHttpGETConnection(String url) {
			InputStream inputStream = null;
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
				inputStream = httpResponse.getEntity().getContent();
			} catch (Exception e) {
				Log.d("", e.getLocalizedMessage());
			}
			return inputStream;
		}

		//---Connects using HTTP POST---
		public InputStream OpenHttpPOSTConnection(String url) {
			InputStream inputStream = null;
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);

				//---set the headers---
				httpPost.addHeader("Host", "www.webservicex.net");
				httpPost.addHeader("Content-Type",
								   "application/x-www-form-urlencoded");

				//---the key/value pairs to post to the server---
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("FromCurrency", "EUR"));
				nameValuePairs.add(new BasicNameValuePair("ToCurrency", "USD"));
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse httpResponse = httpclient.execute(httpPost);
				inputStream = httpResponse.getEntity().getContent();
			} catch (Exception e) {
				Log.d("OpenHttpPOSTConnection", e.getLocalizedMessage());
			}
			return inputStream;
		}
		
		private Bitmap DownloadImage(String URL)
		{        
			Bitmap bitmap = null;
			InputStream in = null;        
			try {
				in = OpenHttpGETConnection(URL);
				bitmap = BitmapFactory.decodeStream(in);
				in.close();
			} catch (Exception e) {
				Log.d("DownloadImage", e.getLocalizedMessage());            
			}
			return bitmap;                
		}

		private class DownloadImageTask extends AsyncTask
		<String, Void, Bitmap> {
			protected Bitmap doInBackground(String... urls) {
				return DownloadImage(urls[0]);
			}

			protected void onPostExecute(Bitmap result) {
				ImageView img = (ImageView) findViewById(R.id.img);
				img.setImageBitmap(result);
			}
		}
		
		private String WordDefinition(String word) {
			InputStream in = null;
			String strDefinition = "";
			try {
				in = OpenHttpGETConnection( 
					"http://services.aonaware.com/DictService/" + 
					"DictService.asmx/Define?word=" + word);
				Document doc = null;
				DocumentBuilderFactory dbf = 
					DocumentBuilderFactory.newInstance();
				DocumentBuilder db;            
				try {
					db = dbf.newDocumentBuilder();
					doc = db.parse(in);
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}            
				doc.getDocumentElement().normalize(); 

				//---retrieve all the <Definition> elements---
				NodeList definitionElements = 
					doc.getElementsByTagName("Definition"); 

				//---iterate through each <Definition> elements---
				for (int i = 0; i < definitionElements.getLength(); i++) { 
					Node itemNode = definitionElements.item(i); 
					if (itemNode.getNodeType() == Node.ELEMENT_NODE) 
					{            
						//---convert the Definition node into an Element---
						Element definitionElement = (Element) itemNode;

						//---get all the <WordDefinition> elements under 
						// the <Definition> element---
						NodeList wordDefinitionElements = 
                            definitionElement.
                            getElementsByTagName("WordDefinition");

						strDefinition = "";
						//---iterate through each <WordDefinition> 
						// elements---
						for (int j = 0; j < 
							 wordDefinitionElements.getLength(); j++) {
							//---get all the child nodes under the 
							// <WordDefinition> element---
							NodeList textNodes = 
                                (wordDefinitionElements.item(j)).
                                getChildNodes();
							strDefinition += 
                                ((Node) 
                                textNodes.item(0)).getNodeValue() + 
                                ". \n";                            
						}
					} 
				}
			} catch (Exception e) {
				Log.d("NetworkingActivity", e.getLocalizedMessage());
			}   
			//---return the definitions of the word---
			return strDefinition;
		}

		private class AccessWebServiceTask extends AsyncTask
		<String, Void, String> {
			protected String doInBackground(String... urls) {
				return WordDefinition(urls[0]);
			}

			protected void onPostExecute(String result) {
				Toast.makeText(getBaseContext(), result, 
							   Toast.LENGTH_LONG).show();
			
		


			//---using HTTP POST---
			new DownloadImageTask()
			.execute("http://smeconcept.com");
				//.execute("http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate");
		}
	}*/
	}
	

