package vowa_antilamer.usb_cfff;

import android.os.Bundle;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.view.MenuItem;
import android.widget.Toast;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 1;

    BluetoothAdapter bluetoothAdapter;

    ArrayList<BluetoothDevice> pairedDeviceArrayList;
    ArrayAdapter<BluetoothDevice> pairedDeviceAdapter;
    private static UUID myUUID;

    private final String UUID_STRING_WELL_KNOWN_SPP =

            "00001101-0000-1000-8000-00805F9B34FB";

    ThreadConnectBTdevice myThreadConnectBTdevice;
    ThreadConnected myThreadConnected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)) {
            Toast.makeText(this,
                    "FEATURE_BLUETOOTH NOT support",
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        myUUID = UUID.fromString(UUID_STRING_WELL_KNOWN_SPP);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this,
                    "Bluetooth is not supported on this hardware platform",
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        SeekBar sk1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar sk2 = (SeekBar) findViewById(R.id.seekBar2);
        SeekBar sk3 = (SeekBar) findViewById(R.id.seekBar3);
        SeekBar sk4 = (SeekBar) findViewById(R.id.seekBar4);
        SeekBar sk5 = (SeekBar) findViewById(R.id.seekBar5);
        SeekBar sk6 = (SeekBar) findViewById(R.id.seekBar6);
        String strInfo = bluetoothAdapter.getName() + "\n" +
                bluetoothAdapter.getAddress();
        Toast.makeText(getApplicationContext(), strInfo, Toast.LENGTH_LONG).show();
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Еще не сделано", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                TextView t1 = (TextView) findViewById(R.id.textred1);
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getBaseContext(), String.valueOf(progress),
                  //      Toast.LENGTH_SHORT).show();
            }
        });
        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                TextView t1 = (TextView) findViewById(R.id.textgreen1);
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getBaseContext(), String.valueOf(progress),
                //      Toast.LENGTH_SHORT).show();
            }
        });
        sk3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                TextView t1 = (TextView) findViewById(R.id.textblue1);
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getBaseContext(), String.valueOf(progress),
                //      Toast.LENGTH_SHORT).show();
            }
        });
        sk4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                TextView t1 = (TextView) findViewById(R.id.textred2);
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getBaseContext(), String.valueOf(progress),
                //      Toast.LENGTH_SHORT).show();
            }
        });
        sk5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                TextView t1 = (TextView) findViewById(R.id.textgreen2);
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getBaseContext(), String.valueOf(progress),
                //      Toast.LENGTH_SHORT).show();
            }
        });
        sk6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                TextView t1 = (TextView) findViewById(R.id.textblue2);
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getBaseContext(), String.valueOf(progress),
                //      Toast.LENGTH_SHORT).show();
            }
        });
    // Example of a call to a native method
  /*  TextView tv = (TextView) findViewById(R.id.sample_text);
    tv.setText(stringFromJNI());*/
    }

    protected void Connect() {
        super.onStart();

        //Turn ON BlueTooth if it is OFF
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice("98:D3:31:30:2B:5E");
        Toast.makeText(MainActivity.this,
                "Name: " + device.getName() + "\n"
                        + "Address: " + device.getAddress() + "\n"
                        + "BondState: " + device.getBondState() + "\n"
                        + "BluetoothClass: " + device.getBluetoothClass() + "\n"
                        + "Class: " + device.getClass(),
                Toast.LENGTH_LONG).show();

        Toast.makeText(MainActivity.this, "start now", Toast.LENGTH_LONG).show();
        myThreadConnectBTdevice = new ThreadConnectBTdevice(device);
        myThreadConnectBTdevice.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_exit:
                System.exit(1);
                return true;
            case R.id.action_settings:
                // Exit option clicked.
                return true;
            case R.id.action_connect:
                Connect();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /*
ThreadConnectBTdevice:
Background Thread to handle BlueTooth connecting
*/
    private class ThreadConnectBTdevice extends Thread {

        private BluetoothSocket bluetoothSocket = null;
        private final BluetoothDevice bluetoothDevice;
        public TextView txtStatus;

        private ThreadConnectBTdevice(BluetoothDevice device) {
            bluetoothDevice = device;
            txtStatus = (TextView) findViewById(R.id.Status);
            try {
                bluetoothSocket = device.createRfcommSocketToServiceRecord(myUUID);
            /*    Toast.makeText(MainActivity.this,
                        "bluetoothSocket: \n" + bluetoothSocket,
                        Toast.LENGTH_SHORT).show();*/
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            boolean success = false;
            try {
                bluetoothSocket.connect();
                success = true;
            } catch (IOException e) {
                e.printStackTrace();

                final String eMessage = e.getMessage();
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                      /*  Toast.makeText(MainActivity.this,
                                "something wrong bluetoothSocket.connect(): \n" + eMessage,
                                Toast.LENGTH_SHORT).show();*/
                    }
                });



                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            if (success) {
                //connect successful

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                       // fab.setEnabled(true);
                      //  fab.setVisibility(FloatingActionButton.VISIBLE);
                        txtStatus.setText("Connect Successful!!!\n");
                    }
                });

                startThreadConnected(bluetoothSocket);

            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtStatus.setText("Connect Fail!\n");
                        cancel();
                    }
                });
            }
        }
        private void startThreadConnected(BluetoothSocket socket) {

            myThreadConnected = new ThreadConnected(socket);
            myThreadConnected.start();
        }
        public void cancel() {

            Toast.makeText(getApplicationContext(),
                    "close bluetoothSocket",
                    Toast.LENGTH_LONG).show();
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    /*
    ThreadConnected:
    Background Thread to handle Bluetooth data communication
    after connected
     */
    private class ThreadConnected extends Thread {
        private final BluetoothSocket connectedBluetoothSocket;
        private final InputStream connectedInputStream;
        private final OutputStream connectedOutputStream;

        boolean running;

        private void closeThreads() {
            if (myThreadConnectBTdevice != null) {
                myThreadConnectBTdevice.cancel();
                myThreadConnectBTdevice = null;
            }

            if (myThreadConnected != null) {
                myThreadConnected.cancel();
                myThreadConnected = null;
            }
        }
        public ThreadConnected(BluetoothSocket socket) {
            connectedBluetoothSocket = socket;
            InputStream in = null;
            OutputStream out = null;
            running = true;
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            connectedInputStream = in;
            connectedOutputStream = out;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;

            String strRx = "";

            while (running) {
                try {
                    bytes = connectedInputStream.read(buffer);
                    final String strReceived = new String(buffer, 0, bytes);
                    final String strByteCnt = String.valueOf(bytes) + " bytes received.\n";

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            //body.append(strReceived);
                        }
                    });

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                    final String msgConnectionLost = "Connection lost:\n"
                            + e.getMessage();

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, msgConnectionLost, Toast.LENGTH_LONG).show();
                            TextView myAwesomeTextView = (TextView) findViewById(R.id.textView);
                            myAwesomeTextView.setText(msgConnectionLost);
                            running=false;
                            closeThreads();
                        }

                    });
                }
            }
        }

        public void write(byte[] buffer) {
            try {
                connectedOutputStream.write(buffer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void cancel() {
            running = false;
            try {
                connectedBluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
