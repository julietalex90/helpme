package com.example.julie.rescueemergency;



        import java.io.DataInputStream;
        import java.io.PrintStream;
        import java.math.BigInteger;
        import java.net.Socket;
        import java.util.HashMap;

        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.widget.Toast;

public class NetworkTask extends AsyncTask<Void, Void, Void> {
    public static	Socket so;
    public static		DataInputStream din;
    public static		PrintStream ps;
public int Mode;
public static String utype;
public String response;
    NetworkTask(int m){
   Mode=m;
    }


    @Override
    protected Void doInBackground(Void... arg0) {



        try {
            if(Mode==0)
            {
                try{
                    so = new Socket("192.168.43.137",9000);
                    ps=new PrintStream(so.getOutputStream());
                    din=new DataInputStream(so.getInputStream());
response="";
                }catch(Exception ee)
                {
                    Log.d("Error", ee.toString());

                }
            }
            else
            {

                response=din.readLine();;
                Log.d("Error","Here"+response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
public static void SendData(String sg)
{
    ps.println(sg);
    ps.flush();
}
    @Override
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);
        try{
        try{
            if(response.startsWith("ADUS"))
            {
           MainActivity.NextForm();
            }
            else if(response.startsWith("ADUF"))
            {
                Toast.makeText(MainActivity.Me.getApplicationContext(), "User Exist", Toast.LENGTH_LONG).show();
            }
           else if(response.startsWith("LOGS"))
            {
                utype=response.substring(4);
              StartForm.NextForm(utype);


            }
        /*    else if(response.startsWith("PREGS"))
            {
                Toast.makeText(PoliceStationReg.Me.getApplicationContext(), "Registartion Completed", Toast.LENGTH_LONG).show();

            }*/
            else if(response.startsWith("LOGF"))
            {
                Toast.makeText(StartForm.me.getApplicationContext(), "Invalid UserID/Password", Toast.LENGTH_LONG).show();
            }




                }catch(Exception ee){ ee.printStackTrace(); }
                Thread.sleep(2);
                NetworkTask myClientTask = new NetworkTask( 1);
                myClientTask.execute();


        }catch(Exception ee)
        {

        }
    }

}

