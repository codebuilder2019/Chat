package servidorChat.sop_rmi;

import servidorChat.dto.FormatoTIADTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.*;
import cliente.sop_rmi.*;

public class GestionAnteproyectosImpl extends UnicastRemoteObject implements GestionAnteproyectosInt
{
    private ArrayList<FormatoTIADTO> formatoTIAs;
    private int contador = 0;

    public GestionAnteproyectosImpl() throws RemoteException
    {
        super(); //invoca al constructor de la clase base
        formatoTIAs = new ArrayList();
        formatoTIBs = new ArrayList();
        formatoTICs = new ArrayList();
        formatoTIDs = new ArrayList();
        registroDTOs = new ArrayList();
    }

    @Override
    public void registrarCallback(RegistroDTO objRegistro) throws RemoteException {
       System.out.println("En regCallbck()");

       if(!(registroDTOs.contains(objRegistro))){
          registroDTOs.add(objRegistro);
          System.out.println("Nuevo objeto adicionado");
       }
    }

    @Override
    public boolean asignarEvaluadores(AsignadoDTO objAsignado) throws RemoteException {
        System.out.println("Asignando evaluadores");

        boolean evaluadoresAsignados = false;

        for (int i = 0; i < formatoTIAs.size(); i++) {
            FormatoTIADTO anteproyectoGuardado = formatoTIAs.get(i);

            if(anteproyectoGuardado.getId() == objAsignado.getIdAnteproyecto()){
                anteproyectoGuardado.setCodigoEvaluador1(objAsignado.getIdEvaluador1());
                anteproyectoGuardado.setCodigoEvaluador2(objAsignado.getIdEvaluador2());
                evaluadoresAsignados = true;
                break;
            }
        }
        
        return evaluadoresAsignados;
    }

    @Override
    public int solicitarCodigo() throws RemoteException {
        System.out.println("Solicitando codigo anteproyecto");

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int period, id;
        
        if (month < 6) {
            period = 1;
        } else {
            period = 2;
        }
        
        contador++;
        id = (year * 10000) + (period * 1000) + (contador);

        return id;
    }

    @Override
    public boolean registrarFormatoTIA(FormatoTIADTO objFormatoTIA) throws RemoteException {
        System.out.println("Registrando FormatoTI-A");

        formatoTIAs.add(objFormatoTIA);
        return true;
    }

    @Override
    public boolean registrarFormatoTIB(FormatoTIBDTO objFormatoTIB) throws RemoteException {
        System.out.println("Registrando FormatoTI-B");

        // Verificar si existe un FormatoTI-A que se corresponda con el FormatoTI-B
        int formatoTIBId = objFormatoTIB.getId();
        
        for (int i = 0; i < formatoTIAs.size(); i++) {
            FormatoTIADTO formatoTIA = formatoTIAs.get(i);
            int formatoTIAId = formatoTIA.getId();

            if(formatoTIAId == formatoTIBId){

                boolean evaluadorEncontrado1 = (objFormatoTIB.getCodigoEvaluador() == formatoTIA.getCodigoEvaluador1());
                boolean evaluadorEncontrado2 = (objFormatoTIB.getCodigoEvaluador() == formatoTIA.getCodigoEvaluador2());

                if(evaluadorEncontrado1 || evaluadorEncontrado2) {
                    formatoTIBs.add(objFormatoTIB);
                    validarAprobaciones(formatoTIAId);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean registrarFormatoTIC(FormatoTICDTO objFormatoTIC) throws RemoteException {
        System.out.println("Registrando FormatoTIC");

        String concepto1 = "";
        String concepto2 = "";

        int anteproyectoId = objFormatoTIC.getId();

        for (int j = 0; j < formatoTIBs.size(); j++) {
            FormatoTIBDTO formatoTIB = formatoTIBs.get(j);

            if(anteproyectoId == formatoTIB.getId()) {
                if(concepto1 == "") {
                    concepto1 = formatoTIB.getConcepto();
                } else {
                    concepto2 = formatoTIB.getConcepto();
                    break;
                }
            }
        }

        boolean concepto1Aprobado = concepto1.equals("aprobado");
        boolean concepto2Aprobado = concepto2.equals("aprobado");

        if(concepto1Aprobado && concepto2Aprobado) {
            formatoTICs.add(objFormatoTIC);
            return true;
        }

        return false;
    }

    @Override
    public boolean registrarFormatoTID(FormatoTIDDTO objFormatoTID) throws RemoteException {
        System.out.println("Registrando FormatoTI-D");

        int formatoTIDId = objFormatoTID.getId();
        
        for (int i = 0; i < formatoTICs.size(); i++) {
            FormatoTICDTO formatoTIC = formatoTICs.get(i);
            int formatoTICId = formatoTIC.getId();

            if(formatoTICId == formatoTIDId){
                formatoTIDs.add(objFormatoTID);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean actualizarFormatoTIB(FormatoTIBDTO objFormatoTIB) throws RemoteException {
        System.out.println("Actualizando FormatoTI-B");

        int objFormatoTIBId = objFormatoTIB.getId();
        
        for (int i = 0; i < formatoTIBs.size(); i++) {
            FormatoTIBDTO formatoTIB = formatoTIBs.get(i);
            int formatoTIBId = formatoTIB.getId();

            if(formatoTIBId == objFormatoTIBId && formatoTIB.getCodigoEvaluador() == objFormatoTIB.getCodigoEvaluador()){
                formatoTIBs.set(i, objFormatoTIB);
                validarAprobaciones(objFormatoTIBId);
                return true;
            }
        }

        return false;
    }
    
    @Override
    public FormatoTIADTO consultarFormatoTIA(int id) throws RemoteException {
        System.out.println("Consultando FormatoTI-A");

        FormatoTIADTO formatoTIA = null;

        for (int i = 0; i < formatoTIAs.size(); i++) {
            int formatoTIAId = formatoTIAs.get(i).getId();

            if(formatoTIAId == id){
                formatoTIA = formatoTIAs.get(i);
                break;
            }
        }

        return formatoTIA;
    }

    @Override
    public ArrayList<FormatoTIBDTO> consultarFormatosTIB(int id) throws RemoteException {
        System.out.println("Consultando FormatoTI-Bs");

        ArrayList<FormatoTIBDTO> formatosB = new ArrayList();

        for (int i = 0; i < formatoTIBs.size(); i++) {
            int formatoTIBId = formatoTIBs.get(i).getId();

            if(formatoTIBId == id){
                FormatoTIBDTO formatoTIB = formatoTIBs.get(i);
                formatosB.add(formatoTIB);

                if(formatosB.size() == 2){
                    break;
                }
            }
        }

        return formatosB;
    }

    @Override
    public FormatoTICDTO consultarFormatoTIC(int id) throws RemoteException {
        System.out.println("Consultando FormatoTI-C");

        FormatoTICDTO formatoTIC = null;

        for (int i = 0; i < formatoTICs.size(); i++) {
            int formatoTICId = formatoTICs.get(i).getId();

            if(formatoTICId == id){
                formatoTIC = formatoTICs.get(i);
                break;
            }
        }

        return formatoTIC;
    }

    @Override
    public FormatoTIDDTO consultarFormatoTID(int id) throws RemoteException {
        System.out.println("Consultando FormatoTI-D");

        FormatoTIDDTO formatoTID = null;

        for (int i = 0; i < formatoTIDs.size(); i++) {
            int formatoTIDId = formatoTIDs.get(i).getId();

            if(formatoTIDId == id){
                formatoTID = formatoTIDs.get(i);
                break;
            }
        }

        return formatoTID;
    }

    @Override
    public ArrayList<FormatoTIADTO> listarFormatosTIA() throws RemoteException {
        System.out.println("Listando FormatoTI-As");

        return formatoTIAs;
    }

    @Override
    public ArrayList<FormatoTIADTO> listarAnteproyectosAsignados(int evaluadorId) throws RemoteException {
        System.out.println("Verificando anteproyectos asignados");

        ArrayList<FormatoTIADTO> anteproyectosAsignados = new ArrayList();

        for (int i = 0; i < formatoTIAs.size(); i++) {
            FormatoTIADTO formatoTIA = formatoTIAs.get(i);

            boolean asignacion1 = (formatoTIA.getCodigoEvaluador1() == evaluadorId);
            boolean asignacion2 = (formatoTIA.getCodigoEvaluador2() == evaluadorId);

            if(asignacion1 || asignacion2) {
                boolean notAssesed = true;

                for (int j = 0; j < formatoTIBs.size(); j++) {
                    FormatoTIBDTO formatoTIB = formatoTIBs.get(j);
                    boolean projectIdFound = (formatoTIA.getId() == formatoTIB.getId());
                    boolean evaluatorIdFound = (evaluadorId == formatoTIB.getCodigoEvaluador());

                    if(projectIdFound && evaluatorIdFound) {
                        notAssesed = false;
                        break;
                    }
                }

                if(notAssesed) {
                    anteproyectosAsignados.add(formatoTIA);
                }
            }
        }

        return anteproyectosAsignados;
    }

    @Override
    public ArrayList<FormatoTIADTO> listarFormatosASinEvaluador(String department) throws RemoteException {
        System.out.println("Listando anteproyectos sin evaluadores");

        ArrayList<FormatoTIADTO> formatsA = new ArrayList();

        for (int i = 0; i < formatoTIAs.size(); i++) {
            FormatoTIADTO formatoTIA = formatoTIAs.get(i);

            if(formatoTIA.getCodigoEvaluador1() == -1) {

                if(department.equals(formatoTIA.getNombrePrograma())){
                    formatsA.add(formatoTIA);
                }
            }
        }

        return formatsA;
    }

    @Override
    public ArrayList<Integer> verificarFormatosCPendientes() throws RemoteException {
        String concepto1;
        String concepto2;

        ArrayList<Integer> formatosBAprobados = new ArrayList<Integer>();

        for (int i = 0; i < formatoTIAs.size(); i++) {
            concepto1 = "";
            concepto2 = "";

            int anteproyectoId = formatoTIAs.get(i).getId();

            for (int j = 0; j < formatoTIBs.size(); j++) {
                FormatoTIBDTO formatoTIB = formatoTIBs.get(j);

                if(anteproyectoId == formatoTIB.getId()) {
                    if(concepto1 == "") {
                        concepto1 = formatoTIB.getConcepto();
                    } else {
                        concepto2 = formatoTIB.getConcepto();
                        
                        boolean concepto1Aprobado = concepto1.equals("aprobado");
                        boolean concepto2Aprobado = concepto2.equals("aprobado");

                        if(concepto1Aprobado && concepto2Aprobado) {
                            formatosBAprobados.add(anteproyectoId);
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < formatoTICs.size(); i++) {
            FormatoTICDTO formatoTIC = formatoTICs.get(i);

            for (int j = 0; j < formatosBAprobados.size(); j++) {
                if(formatoTIC.getId() == formatosBAprobados.get(j)){
                    formatosBAprobados.remove(j);
                    break;
                }
            }
        }
        
        return formatosBAprobados;
    }

    private void validarAprobaciones(int anteproyectoId) throws RemoteException {
        String concepto1 = "";
        String concepto2 = "";

        for (int j = 0; j < formatoTIBs.size(); j++) {
            FormatoTIBDTO formatoTIB = formatoTIBs.get(j);

            if(anteproyectoId == formatoTIB.getId()) {
                if(concepto1 == "") {
                    concepto1 = formatoTIB.getConcepto();
                } else {
                    concepto2 = formatoTIB.getConcepto();
                    break;
                }
            }
        }

        boolean concepto1Aprobado = concepto1.equals("aprobado");
        boolean concepto2Aprobado = concepto2.equals("aprobado");
        
        if(concepto1Aprobado && concepto2Aprobado) {
            for (int i = 0; i < registroDTOs.size(); i++) {
                if(registroDTOs.get(i).getIdAnteproyecto() == anteproyectoId){
                    registroDTOs.get(i).getReferenciaDirector().informarAprobacion(anteproyectoId);
                    break;
                }
            }
        }
    }
}
