package ch04
import org.apache.spark.mllib.linalg.{Vector,Vectors}
/**
  * Created by MKD on 2017/4/15.
  */
object vectorTest {
  def main(args: Array[String]): Unit ={
    val vd: Vector = Vectors.dense(2,0,6)    //建立密集向量
    println(vd(2))//打印稀疏向量的第三个值
    val vs: Vector = Vectors.sparse(4,Array(0,1,2,3),Array(9,5,2,7))//建立稀疏向量
    println(vs(2))//打印稀疏向量第三个值
  }
}
