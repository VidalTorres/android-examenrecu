package com.example.examenrecu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {

    private TextView lblProducto, lblCompra, lblVenta, lblGanancia;
    private Button btnRegresar, btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_producto);

        lblProducto = (TextView) findViewById(R.id.lblProducto);
        lblVenta = (TextView) findViewById(R.id.lblVenta);
        lblCompra = (TextView) findViewById(R.id.lblCompra);
        lblGanancia = (TextView) findViewById(R.id.lblGanancia);

        Bundle datos = getIntent().getExtras();
        EntradaProducto producto = (EntradaProducto) datos.getSerializable("Productos");

        lblProducto.setText("Proucto: "+datos.getString("descripcion"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblVenta.setText("" + producto.calularPrecioVenta());
                lblCompra.setText("" + producto.calcularPrecioCompra());
                lblGanancia.setText("" + producto.calcularGanancia());
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(EntradaProductoActivity.this);
                confirmar.setTitle("Desea regresar?");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                });
                confirmar.show();
            }
        });
    }
}