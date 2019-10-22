//
//  Scene2ViewController.swift
//  Lab5
//
//  Created by Michelle Galetti on 10/21/19.
//  Copyright © 2019 Michelle Galetti. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var userName: UITextField!
    @IBOutlet weak var userAddress: UITextField!
    @IBOutlet weak var userEmail: UITextField!
    @IBOutlet weak var userPhone: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneOrder"{
            let scene1ViewController = segue.destination as! ViewController
            //check to see that text was entered in the textfields
            if userName.text!.isEmpty == false{
                scene1ViewController.user.name=userName.text
            }
            if userAddress.text!.isEmpty == false{
                scene1ViewController.user.address=userAddress.text
            }
            if userEmail.text!.isEmpty == false{
                scene1ViewController.user.email=userEmail.text
            }
            if userPhone.text!.isEmpty == false{
                scene1ViewController.user.phone=userPhone.text
            }
        }
    }
    
    override func viewDidLoad() {
        userName.delegate=self
        userAddress.delegate=self
        userEmail.delegate=self
        userPhone.delegate=self
        super.viewDidLoad()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
        // Do any additional setup after loading the view.
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
