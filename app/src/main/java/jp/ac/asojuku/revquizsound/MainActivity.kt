package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //サウンドプールクラスのインスタンスを生成する
    private  lateinit var soundPool: SoundPool
    private var soundResId=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.kaitoubutton.setOnClickListener {
            kaitoubuttontop(it)
        }


    }
    //出題くんを押した時のメソッド
    fun kaitoubuttontop(view: View?){
        val intent= Intent(this,QuestActivity::class.java)
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()
        soundPool=SoundPool(10,AudioManager.STREAM_SYSTEM,0);
        soundResId=soundPool.load(this,R.raw.decide16,1)
        this.kotaeru.setOnClickListener {
            soundPool.play(soundResId,1.0f,100f,0,0,1.0f)

        }
    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }
}
