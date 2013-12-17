package net.learn2develop.databases;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import java.util.*;
import android.database.sqlite.*;

import android.net.Uri;

import android.text.format.Time;
import android.widget.TimePicker;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.util.ArrayList;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.content.Intent;
import java.text.*;


public class Edit_menu extends Activity {
	EditText ID1;
	EditText amount2;
	EditText amount3;
	EditText amount4;
	EditText amount5;
	EditText sales, address_xxx, emailaddr;
	TextView tttt;
	TextView hours_now;
	Spinner s11;
	TextView Cur_T;
	Button NAME1;
	Button schedule_menu;
	Button edit_menu_button;
	Button add1;
	EditText avalab_mon_from_text;
	EditText availab_tu_to_text;
	EditText ava_fr_n;
	EditText ava_to_n;
	EditText address_1;
	EditText phone;
	EditText phone_db;
	EditText email_db;
	String names;
	String phone_n;
	String string1;
	String ava_fr_n_pres;
	String ava_to_n_pres;
	String presidents1, address_pres, emailaddr_pres;
	double x;
	double y;
	double a;
	double b;
	int d;
	int dd;
	int nnn, mmm, hours_mnfr;
	int id_nn;
	double z;
	double w;
	double e; 
	double hh1;
//	DBContacts DBC;
	Cursor c;
	
	
	Spinner 
	mnfr, mnto, 
	tufr,tuto, 
	wefr, weto, 
	thfr, thto,
	frfr, frto,
	stfr, stto,
	mofr, moto;
	Integer [] hours = {
		0,
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
		23
	};

    DBAdapter db;

	String[] presidents = {
		"Dwight D. Eisenhower",
		"John F. Kennedy",
		"Lyndon B. Johnson",
		"Richard Nixon",
		"Gerald Ford",
		"Jimmy Carter",
		"Ronald Reagan",
		"George H. W. Bush",
		"Bill Clinton",
		"George W. Bush",
		"Barack Obama"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

		db = new DBAdapter(this);
//		DBC= new DBContacts(this);
		
{		
		schedule_menu=(Button)findViewById(R.id.schedule_menu);
		schedule_menu.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent j=new Intent(Edit_menu.this,MainActivity.class);
					startActivity(j);
					finish();
					
}
					});
					
{

	edit_menu_button=(Button)findViewById(R.id.edit_menu_button);
	edit_menu_button.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i=new Intent(Edit_menu.this,EditContactMenu.class);
				startActivity(i);
				finish();

			}				
					});
					
	Button call1=(Button)findViewById(R.id.call1);

	call1.setOnClickListener(new View.OnClickListener() {

			public void onClick (View v) 

			{


				Intent i = new
					Intent(android.content.Intent.ACTION_DIAL, 
						   Uri.parse("tel:+" + phone_n));        
				startActivity(i);


				/*
				 Intent i = new
				 Intent(android.content.Intent.ACTION_CALL, 
				 Uri.parse("tel:+" + phoneNumber));        
				 startActivity(i);     
				 */        



			}
		}
	);			
	

    //	ID1=(EditText)findViewById(R.id.ID1);
	//	id_nn=Integer.parseInt(ID1.getText().toString());
		
		
//		DBC=new DBContacts(this);

					

		s11 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, presidents);
        s11.setAdapter(adapter);

        s11.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
				int index = s11.getSelectedItemPosition();
				
					presidents1=presidents[index];
					nnn=index+1;

				//---get a contact---
					db.open();

					//    String data;

					//		d=Integer.parseInt(ID.getText().toString());	
					Cursor c = db.getContact(nnn);

					//read database	
					if (c !=null){
						c.moveToFirst();   
										 
							String string1=c.getString(0);
							TextView tm_1=(TextView)findViewById(R.id.tm_1);
							tm_1.setText(string1);
							
						String string3=c.getString(1);
						EditText tttt=(EditText)findViewById(R.id.tttt);
						tttt.setText(string3);
						
						String string7=c.getString(3);
						EditText phone_db=(EditText)findViewById(R.id.phone_db);
						phone_db.setText(string7);
				//		phone.setText(string7);
					
						String string8=c.getString(2);
						EditText email_db=(EditText)findViewById(R.id.email_db);
						email_db.setText(string8);
						

						String string9=c.getString(4);
					
					//EditText for every day availability	
				     //monday_from
					    EditText avalab_mon_from_text =(EditText)findViewById(R.id.avalab_mon_from_text);
					    avalab_mon_from_text.setText(string9);
					  //tuesday_from 	
					  	EditText avalab_tu_from_text =(EditText)findViewById(R.id.avalab_tu_from_text);
					    avalab_tu_from_text.setText(string9);
				    	//wednesday_from
						EditText avalab_wed_from_text=(EditText)findViewById(R.id.avalab_wed_from_text);
						avalab_wed_from_text.setText(string9);
						//th
						EditText avalab_th_from_text=(EditText)findViewById(R.id.avalab_th_from_text);
						avalab_th_from_text.setText(string9);
						//fr
						EditText avalab_fr_from_text=(EditText)findViewById(R.id.avalab_fr_from_text);
						avalab_fr_from_text.setText(string9);
						//sat
						EditText avalab_sat_from_text=(EditText)findViewById(R.id.avalab_sat_from_text);
						avalab_sat_from_text.setText(string9);
						//sun
						EditText avalab_sun_from_text=(EditText)findViewById(R.id.avalab_sun_from_text);
						avalab_sun_from_text.setText(string9);
						
						
                       //days_to:
						String string10=c.getString(5);
					
				    	//monday_to
	     				EditText avalab_mon_to_text =(EditText)findViewById(R.id.avalab_mon_to_text);
						avalab_mon_to_text.setText(string10);
						//tuesday_to
						EditText availab_tu_to_text =(EditText)findViewById(R.id.availab_tu_to_text);
						availab_tu_to_text.setText(string10);
						
						EditText availab_wed_to_text =(EditText)findViewById(R.id.availab_wed_to_text);
						availab_wed_to_text.setText(string10);
						
						EditText availab_th_to_text=(EditText)findViewById(R.id.availab_th_to_text);
						availab_th_to_text.setText(string10);
						
						EditText availab_fr_to_text=(EditText)findViewById(R.id.availab_fr_to_text);
						availab_fr_to_text.setText(string10);
						
						EditText availab_sat_to_text=(EditText)findViewById(R.id.availab_sat_to_text);
						availab_sat_to_text.setText(string10);
						
					
						EditText availab_sun_to_text=(EditText)findViewById(R.id.availab_sun_to_text);
						availab_sun_to_text.setText(string10);
					    
						Date dt=new Date();
						int hours_cur=dt.getHours();
						int minutes_cur=dt.getMinutes();
						String cur_Time=hours_cur+":"+minutes_cur;
						EditText hours_now=(EditText)findViewById(R.id.hours_now);
					//	hours_now.setText(Integer.toString(hours_cur));
					    hours_now.setText(cur_Time);
						
						
				//		String string2=c.getString(2);
				//		EditText e_mail=(EditText)findViewById(R.id.e_mail);
				//		e_mail.setText(string2);

					}
				
      
		
			
			
		Button NAME1=(Button)findViewById(R.id.NAME1);
		
		emailaddr=(EditText)findViewById(R.id.emailaddr);
		emailaddr.setText(emailaddr_pres);
		
		phone=(EditText)findViewById(R.id.phone);
		phone.setText(phone_n);
						
		ava_fr_n=(EditText)findViewById(R.id.ava_fr_n);
		ava_fr_n.setText(ava_fr_n_pres);
		
 
		ava_to_n=(EditText)findViewById(R.id.ava_to_n);
		ava_to_n.setText(ava_to_n_pres);
					
		NAME1.setOnClickListener(new View.OnClickListener() {
        
								
				public void onClick (View v) 
				{ 



			//		AddContact();
					
			 
				UpdateContact();
			       
		//	  GetContact();
					

				}

				public void AddContact() {
					//---add a contact---
					db.open();
				
			//		db.deleteContact(d);
			//		Cursor c = db.getContact(1);
			//		d=Integer.parseInt(ID1.getText().toString());	
				//	Cursor c = DBC.getContact(1);
					
					if 
					
					(db.insertContact(presidents1, emailaddr_pres, phone_n, ava_fr_n_pres, ava_to_n_pres,0) >= 0){
								Toast.makeText(getBaseContext(), "Add successful.", Toast.LENGTH_LONG).show();
					}
					else
						Toast.makeText(getBaseContext(), "Did not add.", Toast.LENGTH_LONG).show();
					db.close();
				} 
				
				

				public void GetContact() {

					//---get a contact---
					db.open();

					//    String data;

					//		d=Integer.parseInt(ID.getText().toString());	
					Cursor c = db.getContact(1);

					//read database	 
					if (c !=null){
						c.moveToFirst();   
						String string4=c.getString(3);
						
						
						String string5=c.getString(2);
						EditText tttt=(EditText)findViewById(R.id.tttt);
						tttt.setText(string5);
				/*		
						String string6=c.getString(3);
						EditText address_xxx=(EditText)findViewById(R.id.address_xxx);
						address_xxx.setText(string6);*/

					}

					else
					//			Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
						db.close();}
					
					
					
					

				public void UpdateContact() {
					//---update a contact---
					db.open();
				ID1=(EditText)findViewById(R.id.ID1);
		 	  	d=Integer.parseInt(ID1.getText().toString());	
				
				emailaddr=(EditText)findViewById(R.id.emailaddr);
		        emailaddr_pres=emailaddr.getText().toString();
				
				phone=(EditText)findViewById(R.id.phone);
				phone_n=phone.getText().toString();

				ava_fr_n=(EditText)findViewById(R.id.ava_fr_n);
				ava_fr_n_pres=ava_fr_n.getText().toString();
				

				ava_to_n=(EditText)findViewById(R.id.ava_to_n);
				ava_to_n_pres=ava_to_n.getText().toString();
		
		//		Cursor c = db.getContact(d);
					
					if (db.updateContact(d, presidents1, emailaddr_pres, phone_n, ava_fr_n_pres, ava_to_n_pres,0))
					//			Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
					//		else
					//			Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
						db.close();



					/*   private String getColumnName(String key)
					 { 

					 db.open(); 
					 Cursor c=db.fetchAllData();
					 c.moveToFirst();
					 while(!c.isAfterLast())
					 { if(key.equals(c.getString(c.getColumnIndex("John F. Kennedy"))))
					 //		{ columnName="John F. Kennedy"; } c.moveToNext();

					 c.moveToFirst();  
					 //		String string1=c.getString(1);
					 //	tt.setText(string1);
					 String string2=c.getString(2);
					 EditText e_mail=(EditText)findViewById(R.id.e_mail);
					 e_mail.setText(string2);

					 }
					 return null; */
				}}); }

	


	public void onNothingSelected(AdapterView<?> arg0) {
				
				
				}});
				}
				
				//// Button Add;
				
		Button add1=(Button)findViewById(R.id.add1);

	

		add1.setOnClickListener(new View.OnClickListener() {


				public void onClick (View v) 
				{ 



						AddContact();


				//	UpdateContact();

					//	  GetContact();


				}

				public void AddContact() {
					//---add a contact---
					db.open();

					//		db.deleteContact(d);
					//		Cursor c = db.getContact(1);
					//		d=Integer.parseInt(ID1.getText().toString());	
					//	Cursor c = DBC.getContact(1);

					if 

					(db.insertContact(presidents1, emailaddr_pres, phone_n, ava_fr_n_pres, ava_to_n_pres,0) >= 0){
						Toast.makeText(getBaseContext(), "Add successful.", Toast.LENGTH_LONG).show();
					}
					else
						Toast.makeText(getBaseContext(), "Could not update", Toast.LENGTH_LONG).show();
					Toast.makeText(getBaseContext(), "Did not update", Toast.LENGTH_LONG).show();
					db.close();
				} 



				public void GetContact() {

					//---get a contact---
					db.open();

					//    String data;

					//		d=Integer.parseInt(ID.getText().toString());	
					Cursor c = db.getContact(1);

					//read database	 
					if (c !=null){
						c.moveToFirst();   
						String string4=c.getString(3);


						String string5=c.getString(2);
						EditText tttt=(EditText)findViewById(R.id.tttt);
						tttt.setText(string5);
						/*		
						 String string6=c.getString(3);
						 EditText address_xxx=(EditText)findViewById(R.id.address_xxx);
						 address_xxx.setText(string6);*/

					}

					else
					//			Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
						db.close();}





				public void UpdateContact() {
					//---update a contact---
					db.open();
					ID1=(EditText)findViewById(R.id.ID1);
					d=Integer.parseInt(ID1.getText().toString());	

					emailaddr=(EditText)findViewById(R.id.emailaddr);
					emailaddr_pres=emailaddr.getText().toString();

					phone=(EditText)findViewById(R.id.phone);
					phone_n=phone.getText().toString();

					ava_fr_n=(EditText)findViewById(R.id.ava_fr_n);
					ava_fr_n_pres=ava_fr_n.getText().toString();

					ava_to_n=(EditText)findViewById(R.id.ava_to_n);
					ava_to_n_pres=ava_to_n.getText().toString();

					//		Cursor c = db.getContact(d);

					if (db.updateContact(d, presidents1, emailaddr_pres, phone_n, ava_fr_n_pres, ava_to_n_pres,0))
					//			Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
					//		else
					//			Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
						db.close();



					/*   private String getColumnName(String key)
					 { 

					 db.open(); 
					 Cursor c=db.fetchAllData();
					 c.moveToFirst();
					 while(!c.isAfterLast())
					 { if(key.equals(c.getString(c.getColumnIndex("John F. Kennedy"))))
					 //		{ columnName="John F. Kennedy"; } c.moveToNext();

					 c.moveToFirst();  
					 //		String string1=c.getString(1);
					 //	tt.setText(string1);
					 String string2=c.getString(2);
					 EditText e_mail=(EditText)findViewById(R.id.e_mail);
					 e_mail.setText(string2);

					 }
					 return null; */
				}}); }}





	public void onNothingSelected(AdapterView<?> arg0) {


	};
	
	

				 }
