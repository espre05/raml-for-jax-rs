package server.humanity;

import example.types.ArmImpl;
import example.types.CorpseImpl;
import example.types.Gender;
import example.types.Human;
import example.types.Humanity;
import example.types.Limb;
import example.types.PersonImpl;

import java.util.Collections;
import java.util.Date;

/**
 * Created by Jean-Philippe Belanger on 11/11/16.
 * Just potential zeroes and ones
 */
public class HumanityImpl implements Humanity {


    @Override
    public PutHumanityResponse putHumanity(Human entity) {
        return PutHumanityResponse.respond200();
    }

    @Override
    public GetHumanityResponse getHumanity(String type) {

        if ( "person".equals(type) ) {

            PersonImpl pi = new PersonImpl();
            pi.setGender(Gender.FEMALE);
            pi.setWeight(180);

            pi.setDateOfBirth(new Date());
            pi.setInstantOfBirth(new Date());
            pi.setTimeOfArrival(new Date());
            pi.setDateOfBirth(new Date());
            pi.setTimeOfBirth(new Date());
            pi.setRequestTime(new Date());

            CorpseImpl ci = new CorpseImpl();
            ci.setDateOfDeath(new Date());
            pi.setSiblings(Collections.<Human>singletonList(ci));
            pi.setLimbs(new Limb(new ArmImpl()));
            return GetHumanityResponse.respond200WithApplicationJson(pi);
        } else {

            CorpseImpl ci = new CorpseImpl();
            ci.setGender(Gender.OTHER);
            ci.setDateOfDeath(new Date());
            return GetHumanityResponse.respond200WithApplicationJson(ci);
        }
    }
}
