package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_quest.*

class QuestActivity : AppCompatActivity() {
    private  lateinit var soundPool: SoundPool
    private var seikaisound=0;
    private  var husei=0;
    private  var haku=0
    private  var  q=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)
        //ボタンが押されたときの処理↓
        //不正解
        this.matigai.setOnClickListener { soundPool.play(husei,1.0f,100f,0,0,1.0f) }
        //正解
        this.seikai.setOnClickListener {soundPool.play(seikaisound,1.0f,100f,0,0,1.0f)}
        //拍,
        this.hakusyu.setOnClickListener { soundPool.play(haku,1.0f,100f,0,0,1.0f) }
        //出題
        this.syut.setOnClickListener{soundPool.play(q,1.0f,100f,0,0,1.0f)}
        //回答くん
        this.kaiku.setOnClickListener { kaitubuttontop(it) }
    }
    //回答くんが押されたときの処理
    fun kaitubuttontop(view: View?){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)

    }

    //アクテビティが表示された時
    override fun onResume() {
        super.onResume()
        soundPool=SoundPool(2, AudioManager.STREAM_SYSTEM,0);
        seikaisound=soundPool.load(this,R.raw.quiz1,1)
        husei=soundPool.load(this,R.raw.hu,1)
        haku=soundPool.load(this,R.raw.clap,1);
        q=soundPool.load(this,R.raw.q,1)

    }
}
