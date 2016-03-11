 <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Connections </h1>
                </div>
</div>
<div class="row" ng-controller="connection">
     
     
     <div class="col-lg-3 col-md-6" ng-repeat="cd in conDetails	">
         <div class="panel panel-primary">
             <div class="panel-heading">
                 <div class="row">
                     <div class="col-xs-9 text-right">
                         <div class="huge">{{cd.name}}</div>
                         <div>{{cd.host}}</div>
                     </div>
                 </div>
             </div>
             <a href="#">
                 <div class="panel-footer">
                     <span class="pull-left">View Data</span>
                     <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                     <div class="clearfix"></div>
                 </div>
             </a>
         </div>
     </div>               
</div>