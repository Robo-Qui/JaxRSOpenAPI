package fr.istic.taa.jpa;

import fr.istic.taa.jpa.business.*;
import fr.istic.taa.jpa.dao.*;
import fr.istic.taa.jpa.services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {

	public EntityManager manager;
	private UtilisateurService utilService;
	private ProfessionnelService profService;

	public JpaTest(EntityManager manager){
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JpaTest test = new JpaTest(EntityManagerHelper.getEntityManager());
		test.profService = new ProfessionnelService(new ProfessionnelManager(new CompteManager()),new FreeSlotService(new FreeSlotManager()),new RdvInfosService(new RdvInfosManager(),new IntituleService(new IntituleManager())));
		test.utilService = new UtilisateurService(new UtilisateurManager(new CompteManager()),test.profService,new RendezVousService(new RendezVousManager()));
		EntityTransaction tx = test.manager.getTransaction();
		tx.begin();
		try {
			test.utilService.addUtilisateur(new Utilisateur("PAPOPE","PAPOPE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
}
