package ch04

import org.apache.spark.mllib.linalg.Matrices
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics

/**
  * Created by MKD on 2017/6/24.
  */
object chiSqTest {
  def main(args:Array[String]): Unit ={
    val vd = Vectors.dense(1,2,3,4,5)
    val vdResult = Statistics.chiSqTest(vd)
    println(vdResult)
    println("-------------------------")
    val mtx = Matrices.dense(3,2,Array(1,3,5,2,4,6))
    val mtxResult = Statistics.chiSqTest(mtx)
    println(mtxResult)
  }
}
