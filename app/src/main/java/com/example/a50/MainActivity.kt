package com.example.a50

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun solution(s: String): IntArray {
                var answer: IntArray = Array<Int>(s.length,{0}).toIntArray()
                //b -> -1 a -> -1 n -> -1
                //2차원 배열을 써서 값을 저장한후 그 인덱스값의 차이를 계산하여 answer에 반환
                var list = mutableListOf<Char>()
                var list_index = mutableListOf<Int>()
                for(index in 0..s.length-1){
                    if(list.contains(s[index])){
                        //만약 이전에 나온값 이라면
                        //저장된 인덱스값과 현재 인덱스값을 빼서 그 값은 answer로
                        answer[index] = index - list_index[list.indexOf(s[index])]
                        list_index[list.indexOf(s[index])] = index // 새로은 위치
                    }
                    else{
                        //새로운 값일 경우
                        list_index.add(index)
                        list.add(s[index])
                        answer[index]= -1
                    }
                }
                return answer
            }
        }
        val a = Solution()
        a.solution("banana")
        a.solution("foobar")
    }
}