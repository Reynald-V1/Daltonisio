package tads.eaj.ufrn.daltonisio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonisio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var resposta:ClasseResposta = ClasseResposta("", "", "")


    val setResposta1launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            resposta.resp1 = result.data!!.getStringExtra("respos").toString()
            binding.textViewResposta1.text = "${resposta.resp1}"
        }else{
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta2launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            resposta.resp2 = result.data!!.getStringExtra("respos").toString()
            binding.textViewResposta2.text = "${resposta.resp2}"
        }else{
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta3launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            resposta.resp3 = result.data!!.getStringExtra("respos").toString()
            binding.textViewResposta3.text = "${resposta.resp3}"
        }else{
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button1.setOnClickListener {
            val intent = Intent(this, Tela2::class.java)

            val bundle = Bundle()

            bundle.putInt("imagem", R.drawable.teste1)
            intent.putExtras(bundle)

            setResposta1launcher.launch(intent)

        }

        binding.button2.setOnClickListener {

            val intent = Intent(this, Tela2::class.java)
            val bundle = Bundle()

            bundle.putInt("imagem", R.drawable.teste2)
            intent.putExtras(bundle)

            setResposta2launcher.launch(intent)

        }

        binding.button3.setOnClickListener {
            val intent = Intent(this, Tela2::class.java)

            val bundle = Bundle()

            bundle.putInt("imagem", R.drawable.teste3)
            intent.putExtras(bundle)

            setResposta3launcher.launch(intent)

        }

        binding.botaoVerificar.setOnClickListener {
            binding.resultadoText.text = resposta.resultadoResposta()

        }

    }

    override fun onResume() {
        super.onResume()
        binding.rp = resposta
    }

}