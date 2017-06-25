package ch08

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.GradientBoostedTreesModel
import org.apache.spark.mllib.util.MLUtils
/**
  * Created by MKD on 2017/6/25.
  */
object GDTree {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("GDTree")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//DTree.txt")

    val boostingStrategy = BoostingStrategy.defaultParams("Classification")//创建算法类型
    boostingStrategy.numIterations = 3//迭代次数
    boostingStrategy.treeStrategy.numClasses = 2//分类数目
    boostingStrategy.treeStrategy.maxDepth = 5//决策树最高层数
    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int,Int]()//数据格式

    val model = GradientBoostedTrees.train(data,boostingStrategy)//训练模型
  }
}
