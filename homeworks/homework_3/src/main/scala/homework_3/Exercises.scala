package homework_3

object Exercises {


    /**
     * Задание №1
     * Реализуйте функцию, которая принимает любой тип и преобразует его в строку.
     * Для всех типов кроме Boolean достаточно воспользоваться стандартной функцией .toString.
     * Для типа Boolean сделайте особое преобразование: true -> "правда", false -> "ложь".
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем, как определяется какой тип имеет значение переданное в аргументе. 
     * Определение типа необходимо для реализации специальной логики работы с Boolean значениями, которая описана в условии выше.
     */
    def prettyBooleanFormatter1(x: Any): String = {
        if(x.isInstanceOf[Boolean]) {
            if(x == true)
                return "правда"
            else return "ложь"
        }
        else return x.toString
    }

    def prettyBooleanFormatter2(x: Any): String = {
        x match {
            case true => "правда"
            case false => "ложь"
            case _ => x.toString
        }
    }

    def prettyBooleanFormatter3(x: Any): String = {
        if(x.getClass.getSimpleName == "Boolean"){
            if(x == true)
                return "правда"
            else return "ложь"
        }
        else return x.toString
    }


    /**
     * Задание №2
     * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции. 
     * Обратите внимание на возвращаемые типы.
     */
    def max1(xs: Seq[Int]): Int = {
      if (xs.isEmpty)
        return -6969;
      else {
        return xs.max
      }
    }

    def max2(xs: Seq[Int]): Seq[Int] = {
      if (xs.isEmpty)
        return Seq();
      else {
        return Seq(xs.max);
      }
    }

    def max3(xs: Seq[Int]): Option[Int] = {
      if (xs.isEmpty)
        return None;
      else {
        return Some(xs.max);
      }
    }

    /**
     * Задание №3
     * Допустим дана функция sumIntegers, которая умеет суммировать числа.
     */
    def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

    /**
     * Реализуйте на основе нее 3 варианта суммирования 2х чисел, отличающиеся способом передачи этих 2х чисел в функцию sumIntegers.
     * Как минимум одна из реализаций должна использовать тип данных (класс) написанный вами самостоятельно.
     */ 
    def sum1(x: Int, y: Int): Int = sumIntegers(Seq(x,y))
    def sum2(x: Int, y: Int): Int = sumIntegers(List(x,y))
    def sum3(x: Int, y: Int): Int = sumIntegers(new TransmissionInt(x,y))

    class TransmissionInt(x: Int, y: Int) extends Iterable[Int]{
      override def iterator = Iterator(x,y)
    }
}
