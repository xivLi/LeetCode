import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> myLib = new HashMap<>();
        // 变量 sumImp 记录重要度之和
        int sumImp = 0;
        // 将所有员工放入 map
        for (Employee employee : employees) {
            myLib.put(employee.id, employee);
        }
        // 定义队列，先将首个员工的 id 放入队列，每当队列中的员工 id 出队时，找出这个员工的所有直系下属 id 放入队列
        ArrayDeque<Integer> list = new ArrayDeque<>();
        list.offer(id);

        while (!list.isEmpty()) {
            // 出队一个员工的 id
            int empId = list.poll();
            // 在 map 中找到员工
            Employee employeeTemp = myLib.get(empId);
            // 计入重要度之和
            sumImp += employeeTemp.importance;
            if (employeeTemp.subordinates.size() > 0) {
                // 直系下属 id 入队
                list.addAll(employeeTemp.subordinates);
            }
        }
        return sumImp;
    }
}