package tads.eaj.ufrn.daltonisio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonisio.databinding.ActivityTela2Binding


class Tela2 : AppCompatActivity() {
    private lateinit var binding:ActivityTela2Binding
    lateinit var escolha: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tela2)

        escolha = intent.extras?.getString("escolha").toString()

        val imagem = intent.extras?.getInt("imagem")
        binding.image.setImageResource(imagem!!)
        Log.i("imagem", "$imagem")

        binding.buttonEnviarResposta.setOnClickListener {
            val b = Bundle()

            b.putString("respos", binding.editTextResposta.text.toString())
            intent.putExtras(b)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.cancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}