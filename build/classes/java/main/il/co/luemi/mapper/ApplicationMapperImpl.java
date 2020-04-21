package il.co.luemi.mapper;

import il.co.luemi.model.CustomerDetails;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-14T13:49:37+0530",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ApplicationMapperImpl implements ApplicationMapper {

    @Override
    public il.co.luemi.domain.CustomerDetails mapCustomerDetailsResquestToCustomerDetails(CustomerDetails customerDetailsResquest) {
        if ( customerDetailsResquest == null ) {
            return null;
        }

        il.co.luemi.domain.CustomerDetails customerDetails = new il.co.luemi.domain.CustomerDetails();

        if ( customerDetailsResquest.getMobNo() != null ) {
            customerDetails.setMobileNo( new BigInteger( customerDetailsResquest.getMobNo() ) );
        }
        customerDetails.setCustomerId( customerDetailsResquest.getCustomerId() );
        customerDetails.setName( customerDetailsResquest.getName() );
        customerDetails.setEamilId( customerDetailsResquest.getEamilId() );
        customerDetails.setAddress( customerDetailsResquest.getAddress() );
        customerDetails.setPanNo( customerDetailsResquest.getPanNo() );

        return customerDetails;
    }

    @Override
    public CustomerDetails mapCustomerDetailsDomainToCustomerDetails(il.co.luemi.domain.CustomerDetails customerDetails) {
        if ( customerDetails == null ) {
            return null;
        }

        CustomerDetails customerDetails_ = new CustomerDetails();

        customerDetails_.setMobNo( ApplicationMapper.integerToString( customerDetails.getMobileNo() ) );
        customerDetails_.setCustomerId( customerDetails.getCustomerId() );
        customerDetails_.setName( customerDetails.getName() );
        customerDetails_.setEamilId( customerDetails.getEamilId() );
        customerDetails_.setAddress( customerDetails.getAddress() );
        customerDetails_.setPanNo( customerDetails.getPanNo() );

        return customerDetails_;
    }

    @Override
    public List<CustomerDetails> mapCustomerDetailsDomainToCustomerDetails(List<il.co.luemi.domain.CustomerDetails> customerDetails) {
        if ( customerDetails == null ) {
            return null;
        }

        List<CustomerDetails> list = new ArrayList<CustomerDetails>();
        for ( il.co.luemi.domain.CustomerDetails customerDetails_ : customerDetails ) {
            list.add( mapCustomerDetailsDomainToCustomerDetails( customerDetails_ ) );
        }

        return list;
    }
}
