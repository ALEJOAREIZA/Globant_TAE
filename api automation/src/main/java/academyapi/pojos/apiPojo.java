package academyapi.pojos;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.Serializable;


public class apiPojo implements Serializable{

    private int id;
    private String first_Name;
    private String last_Name;
    private String account_Number;
    private String amount;
    private String transaction_type;
    private String email;
    private boolean active;
    private String country;
    private int  telephone;

    public apiPojo() {
        super();
    }
//    public apiPojo(int id,String FirstName,String Last_Name,String Account_Number,String Amount,String Transaction_type,String Email,boolean Active,String Country,int telephone)
//    {
//
//        this.id = id;
//        this.First_Name = FirstName;
//        this.Last_Name = Last_Name;
//        this.Account_Number = Account_Number;
//        this.Amount = Amount;
//        this.Transaction_type = Transaction_type;
//        this.Email = Email;
//        this.Active = Active;
//        this.Country = Country;
//        this.telephone = telephone;
//    }

        public void setId(int id)
        {
            this.id = id;
        }
        public void setFirst_Name(String First_Name)
        {
            this.first_Name= First_Name;
        }
        public void setLast_Name(String Last_Name)
        {
            this.last_Name= Last_Name;
        }
        public void setAccount_Number(String Account_Number)
        {
            this.account_Number= Account_Number;
        }
        public void setAmount(String Amount)
        {
            this.amount= Amount;
        }
        public void setTransaction_type(String Transaction_type)
        {
            this.transaction_type= Transaction_type;
        }
        public void setEmail(String Email)
        {
            this.email= Email;
        }
        public void setActive(boolean Active)
        {
            this.active= Active;
        }
        public void setCountry(String Country)
        {
            this.country= Country;
        }
        public void setTelephone(int telephone)
        {
            this.telephone= telephone;
        }


        public int getId()
        {
            return id;
        }
        public String getFirst_Name()
        {
            return first_Name;
        }
        public String getLast_Name()
        {
            return last_Name;
        }
        public String getAccount_Number()
        {
            return account_Number;
        }
        public String getAmount()
        {
            return amount;
        }
        public String getTransaction_type()
        {
            return transaction_type;
        }
        public String getEmail()
    {
        return email;
    }
        public boolean getActive()
        {
            return active;
        }
        public String getCountry()
        {
            return country;
        }
        public int getTelephone()
    {
        return telephone;
    }


}