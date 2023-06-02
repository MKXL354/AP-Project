import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientApp{

    public boolean checkData(String regex, String data){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public boolean checkEmail(String email){
        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return checkData(regex, email);
    }

    public boolean checkPhoneNumber(String phoneNumber){
        String regex = "^\\d{7,16}$";
        return checkData(regex, phoneNumber);
    }

    public HashMap<String, String> showCountryCodes(){
        HashMap<String, String> countryList=new HashMap<String, String>();
        String[] locales=Locale.getISOCountries();
        String countryCode;
        String countryName;
        for(String locale:locales){
            Locale countryDetails = Locale.of("en", locale);
            countryCode=countryDetails.getCountry();
            countryName=countryDetails.getDisplayCountry();
            countryList.put(countryCode, countryName);
            System.out.println(countryCode+":"+countryName);
        }
        return countryList;
    }

    public boolean checkCountryCode(String country, HashMap<String, String> countryList){
        String regex = "^[A-Z]{2}$";
        if(checkData(regex, country)==false){
            return false;
        }
        if(!countryList.containsKey(country)){
            return false;
        }
        return true;
    }

    public boolean checkBirthdateFormat(String birthDate){
        String regex = "^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$";
        return checkData(regex, birthDate);
    }

    public boolean checkPassWord(String passWord){
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";
        return(checkData(regex, passWord));
    }

    public void signUp(){
        String userName;
        String firstName;
        String lastName;
        String email;
        String phoneNumber;
        String passWord;
        String country;
        String birthDate;

        Scanner scanner=new Scanner(System.in);
        System.out.println("enter first name: ");
        firstName=scanner.nextLine();

        System.out.println("enter last name: ");
        lastName=scanner.nextLine();

        while(true){
            System.out.println("enter email: ");
            System.out.println("Do you want to use only phone Number? y/n");
            String choice=scanner.nextLine();
            if(choice.equals("y")){
                break;
            }
            else{
                email=scanner.nextLine();
                if(checkEmail(email)==false){
                    System.out.println("wrong format");
                }
                else{
                    break;
                }
            }
        }

        while(true){
            System.out.println("Do you want to use only email? y/n");
            String choice=scanner.nextLine();
            if(choice.equals("y")){
                break;
            }
            else{
                System.out.println("enter phone number: ");
                phoneNumber=scanner.nextLine();
                if(checkPhoneNumber(phoneNumber)==false){
                    System.out.println("wrong format");
                }
                else{
                    break;
                }
            }
        }

        while(true){
            System.out.println("enter country: (2 letter format)");
            HashMap<String, String> countryList=showCountryCodes();
            country=scanner.nextLine();
            if(checkCountryCode(country, countryList)==false){
                System.out.println("wrong input");
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("enter birthdate: (dd/MM/yyyy)");
            birthDate=scanner.nextLine();
            if(!checkBirthdateFormat(birthDate)){
                System.out.println("wrong format");
            }
            else{
                break;
            }
        }

        System.out.println("enter username: ");
        userName=scanner.nextLine();

        while(true){
            System.out.println("enter password: ");
            passWord=scanner.nextLine();
            if(!checkPassWord(passWord)){
                System.out.println("wrong format");
            }
            else{
                break;
            }
        }
        scanner.close();
    }

    public void signIn(){

    }

    public static void main(String[] args){
        ClientApp CA=new ClientApp();
        Scanner scanner=new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("1:sign in\n2:sign up\n3:exit");
            choice=scanner.nextInt();
            if(choice==1){
                CA.signIn();
            }
            else if(choice==2){
                CA.signUp();
            }
            else if(choice==3){
                scanner.close();
                return;
            }
            else{
                continue;
            }
        }
    }
}