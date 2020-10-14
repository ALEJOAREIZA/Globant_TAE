package academyapi.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.sun.istack.internal.NotNull;


import java.io.Serializable;

//@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private String  telephone;

    public apiPojo() {
        super();
    }

        @NotNull
        public void setId(int id)
        {
            this.id = id;
        }
        @NotNull
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

        public void setTelephone(String telephone)
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
        public String getTelephone()
    {
        return telephone;
    }

//    public boolean isnull(){
//        first_Name.isEmpty();
//    }


}