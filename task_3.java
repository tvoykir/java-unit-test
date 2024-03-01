import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)// Напиши аннотацию для параметризованных тестов
public class CheckIsAdultTest {
	
  private final int age;
  private final boolean result;

    
  public CheckIsAdultTest(int age, boolean result) {
        this.age = age;
        this.result = result; // Инициализируй поля класса в конструкторе
  }

  @Parameterized.Parameters // Пометь метод аннотацией для параметров
  public static Object[][] getTextData() {
	return new Object[][] {
            { 15, false }, // Пользователь младше 18 лет
            { 18, true },  // Пользователь ровно 18 лет
            { 19, true },  // Пользователь старше 18 лет
            { 20, true }   // Пользователь старше 18 лет // Заполни массив тестовыми данными и ожидаемым результатом
    };
  }

  @Test
  public void checkIsAdultWhenAgeThenResult() {
	Program program = new Program();
	// Передай сюда возраст пользователя
    boolean isAdult = program.checkIsAdult(age);
	// Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
    assertEquals("Для возраста " + age + " ожидается, что результат будет " + result, result, isAdult);
    }
}
