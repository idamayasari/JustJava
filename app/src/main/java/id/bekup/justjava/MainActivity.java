package id.bekup.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button buttonOrder, buttonTambah, buttonKurang;
    TextView jumlah, order;
    CheckBox whippedCream, cokelat;
    EditText name;

    int quantity = 2;
    int hasil=0;
    boolean hasWhippedCream = true, hasCokelat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOrder = (Button) findViewById(R.id.buttonOrder);
        buttonTambah = (Button) findViewById(R.id.buttonTambah);
        buttonKurang = (Button) findViewById(R.id.buttonKurang);
        jumlah = (TextView) findViewById(R.id.jumlah);
        order = (TextView)findViewById(R.id.order);
        whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        cokelat = (CheckBox) findViewById(R.id.cokelat);
        name = (EditText)findViewById(R.id.name);


        buttonOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              //  Intent i = new Intent(MainActivity.this, TerimaKasih.class);
               // startActivity(i);

                //hasilOrder();

                //hitung harga
                hasil = quantity * 5 ;

                if(whippedCream.isChecked()){
                    hasWhippedCream = true;
                    hasil = hasil + 1;
                }else{
                    hasWhippedCream = false;
                }

                if(cokelat.isChecked()){
                    hasCokelat = true;
                    hasil = hasil + 2;
                }else{
                    hasCokelat = false;
                }

                String nama = name.getText().toString();

                order.setText("Name : "+nama +"\nAdd Whipped Cream ? "+hasWhippedCream +"\nAdd Chocolate ? " + hasCokelat +
                "\nQuantity : "+quantity+"\nTotal : $"+ hasil +"\nThank you!");
            }
        });

        buttonTambah.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //  Intent i = new Intent(MainActivity.this, TerimaKasih.class);
                // startActivity(i);
                tambahJumlah();
                jumlah.setText(""+quantity);

            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //  Intent i = new Intent(MainActivity.this, TerimaKasih.class);
                // startActivity(i);
                kurangJumlah();
                jumlah.setText(""+quantity);

            }
        });
    }

    public void tambahJumlah(){
        if(quantity == 10){
            return;
        }
        quantity = quantity + 1;
    }
    public void kurangJumlah(){
        if(quantity == 1 ){
            return;
        }
        quantity = quantity - 1;
    }

    public void hasilOrder(){
        hasil = quantity * 5 ;

        String keterangan = "Terima kasih \nTotal Biaya $";

        String jumlahTampil = String.valueOf(hasil);
    }

}
