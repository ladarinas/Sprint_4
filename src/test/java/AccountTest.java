
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import io.qameta.allure.junit4.DisplayName;


@DisplayName("Тесты проверки имени")
@RunWith(Parameterized.class)

public class AccountTest {
    private final String fullName;
    private final boolean  expected;

    public AccountTest(String fullName, boolean expected){
        this.fullName = fullName;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[] getFullNameData() {
        return new Object[][] {
                //3 символа
                {"А Я", true},
                //19 символов
                {"Тестик Тестововский",true},
                //2 символа,
                {"Ян", false},
                //20 символов
                {"Тестикс Тестововский",false},
                //пробел в начале
                {" Тестик", false},
                //пробел в конце
                {"Тестик ", false},
                //без пробела
                {"ТестикТестововский", false},
                //два пробела
                {"Тестик Тестов Оглы", false},
                //пустая строка
                {"", false},
                //null
                {null, false}
        };
    }

    @Test
    public void checkNameToPrintTest() {
        Account account = new Account(fullName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
