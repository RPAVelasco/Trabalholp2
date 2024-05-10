package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variável de binding para acessar os componentes da interface do usuário.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da atividade principal usando o binding gerado pelo Data Binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtém o nome de usuário passado da atividade de login, se disponível.
        val username = intent.extras?.getString("username")

        // Se o nome de usuário não estiver vazio, exibe uma mensagem de saudação.
        if (!username.isNullOrEmpty()) {
            binding.textOla.text = "Olá $username"
        }

        // Configura o listener de clique para o botão "Fechar" que encerra todas as atividades.
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        // Configura o listener de clique para o botão "Pedir" que inicia a atividade de splash com informações sobre os pedidos.
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            // Passa as quantidades de pizza, salada e hambúrguer como extras para a próxima atividade.
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            // Finaliza a atividade principal.
            finish()
        }

        // Configura o listener de clique para o checkbox de pizza.
        binding.checkPizza.setOnClickListener {
            // Se o checkbox estiver marcado, define a quantidade como 1 e torna o preço visível; caso contrário, define a quantidade como 0 e oculta o preço.
            if (binding.checkPizza.isChecked()) {
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            } else {
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        // Configura o listener de clique para o checkbox de salada.
        binding.checkSalada.setOnClickListener {
            // Se o checkbox estiver marcado, define a quantidade como 1 e torna o preço visível; caso contrário, define a quantidade como 0 e oculta o preço.
            if (binding.checkSalada.isChecked()) {
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        // Configura o listener de clique para o checkbox de hambúrguer.
        binding.checkHamburger.setOnClickListener {
            // Se o checkbox estiver marcado, define a quantidade como 1 e torna o preço visível; caso contrário, define a quantidade como 0 e oculta o preço.
            if (binding.checkHamburger.isChecked()) {
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }
    }
}
