package com.rota.kongresistem.login;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.rota.kongresistem.Main;
import com.rota.kongresistem.R;
import com.rota.kongresistem.activity.EtkinlikBilgileri;
import com.rota.kongresistem.sevices.Service;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import io.paperdb.Paper;

public class Login extends AppCompatActivity {

    private UserLoginTask mAuthTask = null;
    private String get_mesaj = "false";
    private ProgressDialog progressDialog;
    private String get_token = "";

    @BindView(R.id.edt_name)
    TextView name;
    @BindView(R.id.edt_sifre)
    TextView sifre;
    @BindView(R.id.btn_register)
    Button register;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.btn_remember)
    CheckBox remember_me;

    @OnClick(R.id.btn_register) void SignIn(){

//        Toast.makeText(Login.this, "Kayıt Başarılı",Toast.LENGTH_LONG).show();

          String get_name = name.getText().toString().trim();
          String get_password = sifre.getText().toString().trim();

          if(!TextUtils.isEmpty(get_name) && !TextUtils.isEmpty(get_password)){

              if(remember_me.isChecked()){

                  Boolean boolChecked = remember_me.isChecked();
                  Paper.book().write("userName",get_name);
                  Paper.book().write("Password",get_password);
                  Paper.book().write("Checked",boolChecked);

              }else{
                  Paper.book().delete("userName");
                  Paper.book().delete("Password");
                  Paper.book().delete("Checked");
              }

              mAuthTask = new UserLoginTask(get_name,get_password);
              mAuthTask.execute((Void) null);
          }else{
              Snackbar snackbar = Snackbar
                      .make(coordinatorLayout, getResources().getString(R.string.bilgiler_eksik), Snackbar.LENGTH_LONG);
              snackbar.getView().setBackgroundColor(ContextCompat.getColor(Login.this,R.color.colorAccent));
              snackbar.show();
          }
    }

/*    @OnCheckedChanged(R.id.btn_remember) void Checking(){

        String get_name = name.getText().toString().trim();
        String get_password = sifre.getText().toString().trim();

        if(remember_me.isChecked()){

            Boolean boolChecked = remember_me.isChecked();
            Paper.book().write("userName",get_name);
            Paper.book().write("Password",get_password);
            Paper.book().write("Checked",boolChecked);

        }else{
            Paper.book().delete("userName");
            Paper.book().delete("Password");
            Paper.book().delete("Checked");
        }

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(Login.this);
        Paper.init(Login.this);

        String get_token = Paper.book().read("kongre_token");
        if(get_token != null){

            Intent go_main = new Intent(Login.this,Main.class);
            startActivity(go_main);
            finish();
        }

        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setIndeterminate(true);
        getRemember_meData();

     //for SSL android 4.4 and 5.0
        try {
            ProviderInstaller.installIfNeeded(getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }



    @SuppressLint("StaticFieldLeak")
    public class UserLoginTask extends AsyncTask<Void, Object, Boolean> {

        private final String mUser;
        private final String mPassword;

        UserLoginTask(String username, String password) {
            mUser = username;
            mPassword = password;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage(getResources().getString(R.string.loading));
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            String Result = "false";
                // Simulate network access.
            Result = Service.OpenSession(mUser, mPassword);

            if (!Result.equalsIgnoreCase("false")) {

                Result = Result.substring(Result.indexOf("token=") + 6);
                Result = Result.substring(0, Result.indexOf(";"));
                get_token = Result;
                Paper.book().write("kongre_token",get_token);
                Log.i("get_token",Result);
                get_mesaj = "true";

            }else{
                get_mesaj = "false";
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            progressDialog.dismiss();

            if(get_mesaj.equals("false")){
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, getResources().getString(R.string.giris_hata), Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(Login.this,R.color.colorAccent));
                snackbar.show();
            }else{

                Intent go_mainMenu = new Intent(Login.this,Main.class);
                startActivity(go_mainMenu);
                finish();
            }

         }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            progressDialog.dismiss();
        }

    }

    private void getRemember_meData() {

        String get_name = Paper.book().read("userName");
        String get_password = Paper.book().read("Password");
        Boolean get_checked = Paper.book().read("Checked");

        if(!TextUtils.isEmpty(get_name) && !TextUtils.isEmpty(get_password) && get_checked.equals(true)){

            name.setText(get_name);
            sifre.setText(get_password);
            remember_me.setChecked(true);
        }
    }


}
