package sn.sarr.controller;


import sn.sarr.repository.EntreeRepository;
import sn.sarr.repository.ProduitRepository;
import sn.sarr.repository.jdbc.DataSource;
import sn.sarr.repository.jdbc.MysqlDataSource;
import sn.sarr.repository.jdbc.jdbcBaseEntreeRepository;
import sn.sarr.repository.jdbc.jdbcBaseProduitRepository;
import sn.sarr.service.DisplayService;
import sn.sarr.service.MenuService;
import sn.sarr.service.console.ConsoleDisplayService;
import sn.sarr.service.console.ScannerMenuService;

/**
 * End point destiné aux clients
 * Deux fonctionnalités (services)
 * 1 - Afficher le menu au client : ConsoleDisplayService
 * 2 - Lire les choix du client et afficher le sous-menu correspondant : ScannerMenuService
 */
public class ClientController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;

    public ClientController(){
        DataSource dataSource = new MysqlDataSource();
        displayService = new ConsoleDisplayService();
        ProduitRepository produitRepository = new jdbcBaseProduitRepository(dataSource);
        EntreeRepository entreeRepository = new jdbcBaseEntreeRepository();
        scannerMenuService = new ScannerMenuService(displayService, produitRepository, entreeRepository );
    }

    public void process(){

        displayService.afficherBienvenu();
        displayService.afficherMenuPrincipal();
        scannerMenuService.afficherMenu();
    }


}
