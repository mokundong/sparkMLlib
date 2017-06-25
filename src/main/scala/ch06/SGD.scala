package ch06

import scala.collection.mutable.HashMap

/**
  * Created by MKD on 2017/6/24.随机梯度下降法
  */
object SGD {
  val data = HashMap[Int,Int]()         //创建数据集
  def getData(): HashMap[Int,Int] = {   //生成数据集内容
    for(i <- 1 to 50){                  //创建50个数据
      data += (i -> (12 * i))            //写入公式 y=2x
    }
    data                                  //返回数据集
  }
  var a:Double = 0      //第一步假设a为0
  var b:Double = 0.1    //设置步进系数

  def sgd(x:Double,y:Double) = {          //设置迭代公式
    a = a - b * ((a * x) - y)              //迭代公式
  }

  def main(args: Array[String]): Unit = {
    val dataSource = getData()
    dataSource.foreach(myMap =>{
      sgd(myMap._1,myMap._2)
    })
    println("最终结果b值为" + b)
  }
}
