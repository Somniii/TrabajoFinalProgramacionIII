/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournament.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import seahub.tournamentproyect.logic.Administrador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import seahub.tournament.controller.exceptions.IllegalOrphanException;
import seahub.tournament.controller.exceptions.NonexistentEntityException;
import seahub.tournament.controller.exceptions.PreexistingEntityException;
import seahub.tournamentproyect.logic.Etapa;
import seahub.tournamentproyect.logic.Participante;
import seahub.tournamentproyect.logic.Torneo;

/**
 *
 * @author Alumno
 */
public class TorneoJpaController implements Serializable {

    public TorneoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TorneoJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torneo torneo) throws PreexistingEntityException, Exception {
        if (torneo.getAdministradorCollection() == null) {
            torneo.setAdministradorCollection(new ArrayList<Administrador>());
        }
        if (torneo.getEtapaCollection() == null) {
            torneo.setEtapaCollection(new ArrayList<Etapa>());
        }
        if (torneo.getParticipanteCollection() == null) {
            torneo.setParticipanteCollection(new ArrayList<Participante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Administrador> attachedAdministradorCollection = new ArrayList<Administrador>();
            for (Administrador administradorCollectionAdministradorToAttach : torneo.getAdministradorCollection()) {
                administradorCollectionAdministradorToAttach = em.getReference(administradorCollectionAdministradorToAttach.getClass(), administradorCollectionAdministradorToAttach.getIdAdministrador());
                attachedAdministradorCollection.add(administradorCollectionAdministradorToAttach);
            }
            torneo.setAdministradorCollection(attachedAdministradorCollection);
            Collection<Etapa> attachedEtapaCollection = new ArrayList<Etapa>();
            for (Etapa etapaCollectionEtapaToAttach : torneo.getEtapaCollection()) {
                etapaCollectionEtapaToAttach = em.getReference(etapaCollectionEtapaToAttach.getClass(), etapaCollectionEtapaToAttach.getIdEtapa());
                attachedEtapaCollection.add(etapaCollectionEtapaToAttach);
            }
            torneo.setEtapaCollection(attachedEtapaCollection);
            Collection<Participante> attachedParticipanteCollection = new ArrayList<Participante>();
            for (Participante participanteCollectionParticipanteToAttach : torneo.getParticipanteCollection()) {
                participanteCollectionParticipanteToAttach = em.getReference(participanteCollectionParticipanteToAttach.getClass(), participanteCollectionParticipanteToAttach.getIdParticipante());
                attachedParticipanteCollection.add(participanteCollectionParticipanteToAttach);
            }
            torneo.setParticipanteCollection(attachedParticipanteCollection);
            em.persist(torneo);
            for (Administrador administradorCollectionAdministrador : torneo.getAdministradorCollection()) {
                Torneo oldIdTorneoOfAdministradorCollectionAdministrador = administradorCollectionAdministrador.getIdTorneo();
                administradorCollectionAdministrador.setIdTorneo(torneo);
                administradorCollectionAdministrador = em.merge(administradorCollectionAdministrador);
                if (oldIdTorneoOfAdministradorCollectionAdministrador != null) {
                    oldIdTorneoOfAdministradorCollectionAdministrador.getAdministradorCollection().remove(administradorCollectionAdministrador);
                    oldIdTorneoOfAdministradorCollectionAdministrador = em.merge(oldIdTorneoOfAdministradorCollectionAdministrador);
                }
            }
            for (Etapa etapaCollectionEtapa : torneo.getEtapaCollection()) {
                Torneo oldIdTorneoOfEtapaCollectionEtapa = etapaCollectionEtapa.getIdTorneo();
                etapaCollectionEtapa.setIdTorneo(torneo);
                etapaCollectionEtapa = em.merge(etapaCollectionEtapa);
                if (oldIdTorneoOfEtapaCollectionEtapa != null) {
                    oldIdTorneoOfEtapaCollectionEtapa.getEtapaCollection().remove(etapaCollectionEtapa);
                    oldIdTorneoOfEtapaCollectionEtapa = em.merge(oldIdTorneoOfEtapaCollectionEtapa);
                }
            }
            for (Participante participanteCollectionParticipante : torneo.getParticipanteCollection()) {
                Torneo oldIdTorneoOfParticipanteCollectionParticipante = participanteCollectionParticipante.getIdTorneo();
                participanteCollectionParticipante.setIdTorneo(torneo);
                participanteCollectionParticipante = em.merge(participanteCollectionParticipante);
                if (oldIdTorneoOfParticipanteCollectionParticipante != null) {
                    oldIdTorneoOfParticipanteCollectionParticipante.getParticipanteCollection().remove(participanteCollectionParticipante);
                    oldIdTorneoOfParticipanteCollectionParticipante = em.merge(oldIdTorneoOfParticipanteCollectionParticipante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTorneo(torneo.getIdTorneo()) != null) {
                throw new PreexistingEntityException("Torneo " + torneo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Torneo torneo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo persistentTorneo = em.find(Torneo.class, torneo.getIdTorneo());
            Collection<Administrador> administradorCollectionOld = persistentTorneo.getAdministradorCollection();
            Collection<Administrador> administradorCollectionNew = torneo.getAdministradorCollection();
            Collection<Etapa> etapaCollectionOld = persistentTorneo.getEtapaCollection();
            Collection<Etapa> etapaCollectionNew = torneo.getEtapaCollection();
            Collection<Participante> participanteCollectionOld = persistentTorneo.getParticipanteCollection();
            Collection<Participante> participanteCollectionNew = torneo.getParticipanteCollection();
            List<String> illegalOrphanMessages = null;
            for (Administrador administradorCollectionOldAdministrador : administradorCollectionOld) {
                if (!administradorCollectionNew.contains(administradorCollectionOldAdministrador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Administrador " + administradorCollectionOldAdministrador + " since its idTorneo field is not nullable.");
                }
            }
            for (Etapa etapaCollectionOldEtapa : etapaCollectionOld) {
                if (!etapaCollectionNew.contains(etapaCollectionOldEtapa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Etapa " + etapaCollectionOldEtapa + " since its idTorneo field is not nullable.");
                }
            }
            for (Participante participanteCollectionOldParticipante : participanteCollectionOld) {
                if (!participanteCollectionNew.contains(participanteCollectionOldParticipante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Participante " + participanteCollectionOldParticipante + " since its idTorneo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Administrador> attachedAdministradorCollectionNew = new ArrayList<Administrador>();
            for (Administrador administradorCollectionNewAdministradorToAttach : administradorCollectionNew) {
                administradorCollectionNewAdministradorToAttach = em.getReference(administradorCollectionNewAdministradorToAttach.getClass(), administradorCollectionNewAdministradorToAttach.getIdAdministrador());
                attachedAdministradorCollectionNew.add(administradorCollectionNewAdministradorToAttach);
            }
            administradorCollectionNew = attachedAdministradorCollectionNew;
            torneo.setAdministradorCollection(administradorCollectionNew);
            Collection<Etapa> attachedEtapaCollectionNew = new ArrayList<Etapa>();
            for (Etapa etapaCollectionNewEtapaToAttach : etapaCollectionNew) {
                etapaCollectionNewEtapaToAttach = em.getReference(etapaCollectionNewEtapaToAttach.getClass(), etapaCollectionNewEtapaToAttach.getIdEtapa());
                attachedEtapaCollectionNew.add(etapaCollectionNewEtapaToAttach);
            }
            etapaCollectionNew = attachedEtapaCollectionNew;
            torneo.setEtapaCollection(etapaCollectionNew);
            Collection<Participante> attachedParticipanteCollectionNew = new ArrayList<Participante>();
            for (Participante participanteCollectionNewParticipanteToAttach : participanteCollectionNew) {
                participanteCollectionNewParticipanteToAttach = em.getReference(participanteCollectionNewParticipanteToAttach.getClass(), participanteCollectionNewParticipanteToAttach.getIdParticipante());
                attachedParticipanteCollectionNew.add(participanteCollectionNewParticipanteToAttach);
            }
            participanteCollectionNew = attachedParticipanteCollectionNew;
            torneo.setParticipanteCollection(participanteCollectionNew);
            torneo = em.merge(torneo);
            for (Administrador administradorCollectionNewAdministrador : administradorCollectionNew) {
                if (!administradorCollectionOld.contains(administradorCollectionNewAdministrador)) {
                    Torneo oldIdTorneoOfAdministradorCollectionNewAdministrador = administradorCollectionNewAdministrador.getIdTorneo();
                    administradorCollectionNewAdministrador.setIdTorneo(torneo);
                    administradorCollectionNewAdministrador = em.merge(administradorCollectionNewAdministrador);
                    if (oldIdTorneoOfAdministradorCollectionNewAdministrador != null && !oldIdTorneoOfAdministradorCollectionNewAdministrador.equals(torneo)) {
                        oldIdTorneoOfAdministradorCollectionNewAdministrador.getAdministradorCollection().remove(administradorCollectionNewAdministrador);
                        oldIdTorneoOfAdministradorCollectionNewAdministrador = em.merge(oldIdTorneoOfAdministradorCollectionNewAdministrador);
                    }
                }
            }
            for (Etapa etapaCollectionNewEtapa : etapaCollectionNew) {
                if (!etapaCollectionOld.contains(etapaCollectionNewEtapa)) {
                    Torneo oldIdTorneoOfEtapaCollectionNewEtapa = etapaCollectionNewEtapa.getIdTorneo();
                    etapaCollectionNewEtapa.setIdTorneo(torneo);
                    etapaCollectionNewEtapa = em.merge(etapaCollectionNewEtapa);
                    if (oldIdTorneoOfEtapaCollectionNewEtapa != null && !oldIdTorneoOfEtapaCollectionNewEtapa.equals(torneo)) {
                        oldIdTorneoOfEtapaCollectionNewEtapa.getEtapaCollection().remove(etapaCollectionNewEtapa);
                        oldIdTorneoOfEtapaCollectionNewEtapa = em.merge(oldIdTorneoOfEtapaCollectionNewEtapa);
                    }
                }
            }
            for (Participante participanteCollectionNewParticipante : participanteCollectionNew) {
                if (!participanteCollectionOld.contains(participanteCollectionNewParticipante)) {
                    Torneo oldIdTorneoOfParticipanteCollectionNewParticipante = participanteCollectionNewParticipante.getIdTorneo();
                    participanteCollectionNewParticipante.setIdTorneo(torneo);
                    participanteCollectionNewParticipante = em.merge(participanteCollectionNewParticipante);
                    if (oldIdTorneoOfParticipanteCollectionNewParticipante != null && !oldIdTorneoOfParticipanteCollectionNewParticipante.equals(torneo)) {
                        oldIdTorneoOfParticipanteCollectionNewParticipante.getParticipanteCollection().remove(participanteCollectionNewParticipante);
                        oldIdTorneoOfParticipanteCollectionNewParticipante = em.merge(oldIdTorneoOfParticipanteCollectionNewParticipante);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = torneo.getIdTorneo();
                if (findTorneo(id) == null) {
                    throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo torneo;
            try {
                torneo = em.getReference(Torneo.class, id);
                torneo.getIdTorneo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Administrador> administradorCollectionOrphanCheck = torneo.getAdministradorCollection();
            for (Administrador administradorCollectionOrphanCheckAdministrador : administradorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torneo (" + torneo + ") cannot be destroyed since the Administrador " + administradorCollectionOrphanCheckAdministrador + " in its administradorCollection field has a non-nullable idTorneo field.");
            }
            Collection<Etapa> etapaCollectionOrphanCheck = torneo.getEtapaCollection();
            for (Etapa etapaCollectionOrphanCheckEtapa : etapaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torneo (" + torneo + ") cannot be destroyed since the Etapa " + etapaCollectionOrphanCheckEtapa + " in its etapaCollection field has a non-nullable idTorneo field.");
            }
            Collection<Participante> participanteCollectionOrphanCheck = torneo.getParticipanteCollection();
            for (Participante participanteCollectionOrphanCheckParticipante : participanteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torneo (" + torneo + ") cannot be destroyed since the Participante " + participanteCollectionOrphanCheckParticipante + " in its participanteCollection field has a non-nullable idTorneo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(torneo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Torneo> findTorneoEntities() {
        return findTorneoEntities(true, -1, -1);
    }

    public List<Torneo> findTorneoEntities(int maxResults, int firstResult) {
        return findTorneoEntities(false, maxResults, firstResult);
    }

    private List<Torneo> findTorneoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torneo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Torneo findTorneo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torneo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorneoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torneo> rt = cq.from(Torneo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
