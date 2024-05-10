package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade de splash.
        setContentView(R.layout.activity_splash)

        // Cria um objeto Handler para lidar com o atraso na execução da próxima atividade.
        Handler(Looper.getMainLooper()).postDelayed({
            // Obtém a Intent que iniciou esta atividade.
            val i = intent
            // Cria uma nova Intent para iniciar a atividade de pedido (PedidoActivity).
            val j = Intent(this, PedidoActivity::class.java)
            // Passa todos os extras da Intent atual para a nova Intent.
            j.putExtras(i)
            // Inicia a atividade de pedido.
            startActivity(j)
            // Finaliza a atividade de splash para que o usuário não possa retornar pressionando o botão "Voltar".
            finish()
        }, 2000) // Define o atraso em milissegundos (neste caso, 2000ms ou 2 segundos).
    }
}
