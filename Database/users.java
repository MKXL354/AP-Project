public class users {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private int phone;
    private int country_code;
    private String bio;
    private String birth_date;
    private String profile;
    private String header;
    private String create_timestamp;
    private String update_timesdtamp;

    public users(String username,String password,String first_name,String last_name,String email,
                int phone,int country_code,String bio,String birth_date,String profile,String header,
                String create_timestamp,String update_timesdtamp){
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.country_code = country_code;
        this.bio = bio;
        this.birth_date = birth_date;
        this.profile = profile;
        this.header = header;
        this.create_timestamp = create_timestamp;
        this.update_timesdtamp = update_timesdtamp;
    }

    String getUsername(){
        return username;
    }
    String getPassword(){
        return password;
    }
    String getFirst_name(){
        return first_name;
    }
    String getLast_name(){
        return last_name;
    }
    String getEmail(){
        return email;
    }
    int getPhone(){
        return phone;
    }
    int getCountry_code(){
        return country_code;
    }
    String getBio(){
        return bio;
    }
    String getBirth_date(){
        return birth_date;
    }
    String getProfile(){
        return profile;
    }
    String getHeader(){
        return header;
    }
    String getCreate_timestamp(){
        return create_timestamp;
    }
    String getUpdate_timestamp(){
        return update_timesdtamp;
    }
}
