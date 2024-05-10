package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    // Variável de binding para acessar os componentes da interface do usuário.
    private lateinit var binding: ActivityPedidoBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da atividade de pedido usando o binding gerado pelo Data Binding.
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtém os extras passados pela Intent.
        val i = intent
        // Extrai as quantidades de pizza, salada e hambúrguer e as converte para inteiro.
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        // Cria o texto do resumo do pedido com base nas quantidades e preços.
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza * 8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada * 10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer * 12}\n"

        // Define o texto do resumo do pedido no TextView correspondente.
        binding.textResumo.text = texto
    }
}
