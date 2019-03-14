package ps;

public class MultipleInheritance implements Interface1, Interface2{

        @Override
        public void method2() {
        }

        @Override
        public void method1(String str) {
        }

        @Override
        public void log(String str) {
            System.out.println("Multiple Inheritance using default keyword : " + str);
            Interface1.print(str);
        }


        public static void main(String arg[]){
            MultipleInheritance multipleInheritance = new MultipleInheritance();
            multipleInheritance.log("wow");
        }
}
