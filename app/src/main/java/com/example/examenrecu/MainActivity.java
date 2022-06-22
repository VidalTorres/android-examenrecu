package com.example.examenrecu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtCodigo;
    private EditText txtDescripcion;
    private EditText txtUnidad;
    private EditText txtPrecioVenta;
    private EditText txtPrecioCompra;
    private EditText txtCantidad;

    private Button btnEnviar;
    private Button btnLimpiar;
    private Button btnCerrar;

    private EntradaProducto producto = new EntradaProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtUnidad = (EditText) findViewById(R.id.txtUnidad);
        txtPrecioVenta = (EditText) findViewById(R.id.txtPrecioVenta);
        txtPrecioCompra = (EditText) findViewById(R.id.txtPrecioCompra);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCodigo.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Dato faltante: Codigo", Toast.LENGTH_SHORT).show();
                }
                else if(txtDescripcion.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Dato faltante: Descripcion", Toast.LENGTH_SHORT).show();
                }
                else if(txtUnidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Dato faltante: Unidad", Toast.LENGTH_SHORT).show();
                }
                else if(txtPrecioVenta.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Dato faltante: Precio venta", Toast.LENGTH_SHORT).show();
                }
                else if(txtPrecioCompra.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Dato faltante: Precio compra", Toast.LENGTH_SHORT).show();
                }
                else if(txtCantidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Dato faltante: Cantidad", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, EntradaProductoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("codigo", txtCodigo.getText().toString());
                    bundle.putSerializable("descripcion", txtDescripcion.getText().toString());
                    bundle.putSerializable("unidad", txtUnidad.getText().toString());
                    bundle.putSerializable("venta", txtPrecioVenta.getText().toString());
                    bundle.putSerializable("compra", txtPrecioCompra.getText().toString());
                    bundle.putSerializable("cantidad", txtCantidad.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtPrecioCompra.setText("");
                txtUnidad.setText("");
                txtCantidad.setText("");
                txtPrecioVenta.setText("");
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
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