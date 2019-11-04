//
//  ViewController.swift
//  Lab5
//
//  Created by Michelle Galetti on 10/21/19.
//  Copyright © 2019 Michelle Galetti. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var addressLabel: UILabel!
    @IBOutlet weak var emailLabel: UILabel!
    @IBOutlet weak var phoneLabel: UILabel!
    
    var user=Order()
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        nameLabel.text=user.name
        addressLabel.text=user.address
        emailLabel.text=user.email
        phoneLabel.text=user.phone
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

